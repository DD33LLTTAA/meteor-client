import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public final class class4 {
	@ObfuscatedName("ix")
	static int field2;

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Lio;",
		garbageValue = "-2052088854"
	)
	public static FloorOverlayDefinition method4(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class30.FloorOverlayDefinition_archive.takeFile(4, var0);
			var1 = new FloorOverlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "71"
	)
	static final void method5(int var0, int var1, int var2) {
		int var3;
		for (var3 = 0; var3 < 8; ++var3) {
			for (int var4 = 0; var4 < 8; ++var4) {
				Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
			}
		}

		if (var1 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
			}
		}

		if (var2 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
			}
		}

		if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
		} else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "159845582"
	)
	static int method6(int var0, Script var1, boolean var2) {
		boolean var3 = true;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			var3 = false;
		} else {
			var4 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
		}

		int var11;
		if (var0 == 1300) {
			var11 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
			if (var11 >= 0 && var11 <= 9) {
				var4.setAction(var11, Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize]);
				return 1;
			} else {
				--class180.Interpreter_stringStackSize;
				return 1;
			}
		} else {
			int var6;
			if (var0 == 1301) {
				Interpreter.Interpreter_intStackSize -= 2;
				var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var4.parent = class33.widgetDefinition.getWidgetChild(var11, var6);
				return 1;
			} else if (var0 == 1302) {
				var4.isScrollBar = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == 1303) {
				var4.dragZoneSize = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1304) {
				var4.dragThreshold = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1305) {
				var4.dataText = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == 1306) {
				var4.spellActionName = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == 1307) {
				var4.actions = null;
				return 1;
			} else if (var0 == 1308) {
				var4.prioritizeMenuEntry = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == 1309) {
				--Interpreter.Interpreter_intStackSize;
				return 1;
			} else {
				int var7;
				byte[] var9;
				if (var0 != 1350) {
					byte var5;
					if (var0 == 1351) {
						Interpreter.Interpreter_intStackSize -= 2;
						var5 = 10;
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
						byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
						InterfaceParent.Widget_setKey(var4, var5, var9, var10);
						return 1;
					} else if (var0 == 1352) {
						Interpreter.Interpreter_intStackSize -= 3;
						var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
						var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						if (var11 >= 0 && var11 <= 9) {
							ScriptFrame.Widget_setKeyRate(var4, var11, var6, var7);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == 1353) {
						var5 = 10;
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						ScriptFrame.Widget_setKeyRate(var4, var5, var6, var7);
						return 1;
					} else if (var0 == 1354) {
						--Interpreter.Interpreter_intStackSize;
						var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
						if (var11 >= 0 && var11 <= 9) {
							class18.Widget_setKeyIgnoreHeld(var4, var11);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == 1355) {
						var5 = 10;
						class18.Widget_setKeyIgnoreHeld(var4, var5);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var8 = null;
					var9 = null;
					if (var3) {
						Interpreter.Interpreter_intStackSize -= 10;

						for (var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize] >= 0; var7 += 2) {
						}

						if (var7 > 0) {
							var8 = new byte[var7 / 2];
							var9 = new byte[var7 / 2];

							for (var7 -= 2; var7 >= 0; var7 -= 2) {
								var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize];
								var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize + 1];
							}
						}
					} else {
						Interpreter.Interpreter_intStackSize -= 2;
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
					}

					var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
					if (var7 >= 0 && var7 <= 9) {
						InterfaceParent.Widget_setKey(var4, var7, var8, var9);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "1678584936"
	)
	static int method7(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 8000) {
			--Interpreter.Interpreter_intStackSize;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_arrayLengths[var3];
			Frames.method1337(Interpreter.Interpreter_arrays[var3], new int[var4], 0, var4 - 1);
			return 1;
		} else if (var0 == 8001) {
			Interpreter.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			int var6 = Interpreter.Interpreter_arrayLengths[var3];
			if (var6 <= 1) {
				return 1;
			} else {
				class424.method2177(Interpreter.Interpreter_arrays[var3], var6, var4, var5);
				return 1;
			}
		} else {
			return 2;
		}
	}
}