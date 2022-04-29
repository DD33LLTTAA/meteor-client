package dev.hoot.api.items;

import dev.hoot.api.game.Game;
import dev.hoot.api.game.GameThread;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.widgets.WidgetInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Equipment extends Items
{
	private Equipment()
	{
	}

	private static final Equipment EQUIPMENT = new Equipment();

	@Override
	protected List<Item> all(Predicate<Item> filter)
	{
		List<Item> items = new ArrayList<>();
		ItemContainer container = Game.getClient().getItemContainer(InventoryID.EQUIPMENT);
		if (container == null)
		{
			return items;
		}

		Item[] containerItems = container.getItems();

		// temp workaround for caching defs
		Client client = Game.getClient();
		List<Item> uncachedItems = Arrays.stream(containerItems)
				.filter(i -> !client.isItemDefinitionCached(i.getId()))
				.collect(Collectors.toList());
		if (!uncachedItems.isEmpty())
		{
			GameThread.invokeLater(() -> {
				for (Item uncachedItem : uncachedItems)
				{
					int id = uncachedItem.getId();
					client.cacheItem(id, client.getItemComposition(id));
				}

				return null;
			});
		}

		for (Item item : containerItems) {
			if (item.getId() != -1 && item.getName() != null && !item.getName().equals("null")) {
				item.container = InventoryID.EQUIPMENT;
				WidgetInfo widgetInfo = getEquipmentWidgetInfo(item.getSlot());
				item.setActionParam(-1);

				if (widgetInfo != null) {
					item.setWidgetId(widgetInfo.getPackedId());

					if (filter.test(item)) {
						items.add(item);
					}
				}
			}
		}

		return items;
	}

	public static List<Item> getAll(Predicate<Item> filter)
	{
		return EQUIPMENT.all(filter);
	}

	public static List<Item> getAll()
	{
		return getAll(x -> true);
	}

	public static List<Item> getAll(int... ids)
	{
		return EQUIPMENT.all(ids);
	}

	public static List<Item> getAll(String... names)
	{
		return EQUIPMENT.all(names);
	}

	public static Item getFirst(Predicate<Item> filter)
	{
		return EQUIPMENT.first(filter);
	}

	public static Item getFirst(int... ids)
	{
		return EQUIPMENT.first(ids);
	}

	public static Item getFirst(String... names)
	{
		return EQUIPMENT.first(names);
	}

	private static WidgetInfo getEquipmentWidgetInfo(int itemIndex)
	{
		for (EquipmentInventorySlot equipmentInventorySlot : EquipmentInventorySlot.values())
		{
			if (equipmentInventorySlot.getSlotIdx() == itemIndex)
			{
				return equipmentInventorySlot.getWidgetInfo();
			}
		}

		return null;
	}

	public static boolean contains(Predicate<Item> filter)
	{
		return EQUIPMENT.exists(filter);
	}

	public static boolean contains(int... id)
	{
		return EQUIPMENT.exists(id);
	}

	public static boolean contains(String... name)
	{
		return EQUIPMENT.exists(name);
	}

	public static int getCount(boolean stacks, Predicate<Item> filter)
	{
		return EQUIPMENT.count(stacks, filter);
	}

	public static int getCount(boolean stacks, int... ids)
	{
		return EQUIPMENT.count(stacks, ids);
	}

	public static int getCount(boolean stacks, String... names)
	{
		return EQUIPMENT.count(stacks, names);
	}

	public static int getCount(Predicate<Item> filter)
	{
		return EQUIPMENT.count(false, filter);
	}

	public static int getCount(int... ids)
	{
		return EQUIPMENT.count(false, ids);
	}

	public static int getCount(String... names)
	{
		return EQUIPMENT.count(false, names);
	}

	public static Item fromSlot(EquipmentInventorySlot slot)
	{
		return getFirst(x -> slot.getWidgetInfo().getPackedId() == x.getWidgetId());
	}
}
