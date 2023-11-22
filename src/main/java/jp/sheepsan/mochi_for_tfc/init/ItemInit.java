package jp.sheepsan.mochi_for_tfc.init;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

import jp.sheepsan.mochi_for_tfc.MochiForTFCMain;
import jp.sheepsan.mochi_for_tfc.items.MochiFoodEnum;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.dries007.tfc.util.Helpers;

import net.dries007.tfc.common.items.DecayingItem;



public class ItemInit {
	// DeferredRegister （Itemクラスを登録するクラス）インスタンスを生成する
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MochiForTFCMain.MOD_ID);
	
	/* アイテムを登録する */
	// 通常の Food アイテム（特殊効果を持たないもの）を一括で登録する
	/*
	static Supplier<DecayingItem> supplier2 = () -> new DecayingItem(new Item.Properties()
			.tab(MochiForTFCTab.instance)
			.food(MochiFoodEnum.ZUNDA_MOCHI.getFoodPropertiesBuilder())
			); 
	*/
	/*
	public static final RegistryObject<Item> ZUNDA_MOCHI = items_register("food/" + MochiFoodEnum.ZUNDA_MOCHI.name(), 
			() -> new Item(new Item.Properties().tab(MochiForTFCTab.instance))
			);
	*/
	
	public static final Map<MochiFoodEnum, RegistryObject<Item>> FOODS = Helpers.mapOfKeys(
			MochiFoodEnum.class,
			food -> items_register("food/" + food.name(),
					() -> new DecayingItem(new Item.Properties()
							.food(food.getFoodPropertiesBuilder()).
							tab(MochiForTFCTab.instance)
							)));
	
	/*
	public static final RegistryObject<Item> ZUNDA_MOCHI2 = ITEMS.register("food/zunda_mochi",
			() -> new Item(new Item.Properties().tab(MochiForTFCTab.instance)) // Property settings
			);
	

	
	// ゆでた枝豆
	public static final RegistryObject<Item> BOILED_GREENBEAN = ITEMS.register("food/boiled_greenbean",
			() -> new Item(new Item.Properties().tab(MochiForTFCTab.instance))
			);
	
	*/
	
	// アイテムの登録を一括で行うためのメソッド
	private static RegistryObject<Item> register(String name, CreativeModeTab group) {
		// ITEMS.register へ渡すための Supplier
		Supplier<Item> sup = () -> new Item(new Item.Properties().tab(group));
		return items_register(name, sup); // ITEMS.register を行うメソッドへ引数渡し
	}
	
	// ITEMS へ RegistryObject を登録するためのメソッド。
	// 対応する Supplier の型は Items またはその子クラス
	private static <T extends Item> RegistryObject<T> items_register(String name, Supplier<T> itemSup){
		return ITEMS.register(name.toLowerCase(Locale.ROOT), // enumクラスには大文字で登録されているので、小文字に変換して登録する
				itemSup // Supplier<T>: T 型のインスタンスを返り値とする、引数を持たない関数 : () -> new T();
				);
	}
	
	// クリエイティブモードで使用するタブを作成する
	public static class MochiForTFCTab extends CreativeModeTab {
		public static final MochiForTFCTab instance = new MochiForTFCTab(CreativeModeTab.TABS.length, "mochi_for_tfc");
		
		// Constructor
		private MochiForTFCTab(
				int index, // アイテムグループの場所
				String label // マウスホバーした時のラベル
				)
		{
			super(index, label);
		}
		
		@Override
		public ItemStack makeIcon() {
			// configure Icon for GUI
			return new ItemStack(Items.ACACIA_BOAT); // get()で参照
			// とりあえずアカシアのボートを暫定的にタブアイコンに設定
			// TODO: アイコン変更
		}
	}

}
