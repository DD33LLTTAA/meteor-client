import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oq")
public class Ignored extends User {
   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive field4539;
   @ObfuscatedName("h")
   int id;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Loq;I)I",
      garbageValue = "1170247558"
   )
   int compareTo_ignored(Ignored var1) {
      return this.id - var1.id;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lov;I)I",
      garbageValue = "-1893146393"
   )
   public int compareTo_user(User var1) {
      return this.compareTo_ignored((Ignored)var1);
   }

   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.compareTo_ignored((Ignored)var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;B)V",
      garbageValue = "67"
   )
   public static void method7606(AbstractArchive var0) {
      DbTableType.field4882 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "1288576993"
   )
   public static int method7614(int var0, int var1) {
      return (int)Math.round(Math.atan2((double)var0, (double)var1) * 2607.5945876176133D) & 16383;
   }
}
