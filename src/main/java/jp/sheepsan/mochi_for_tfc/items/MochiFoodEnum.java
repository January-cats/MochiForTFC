package jp.sheepsan.mochi_for_tfc.items;

import net.minecraft.world.food.FoodProperties;

public enum MochiFoodEnum {
	// TFCに追加する食べ物
	// そのうち、食べた時に栄養回復・満腹度回復以外のステータスを持たないもの。
	ZUNDA_MOCHI,
	BOILED_GREENBEAN,
	GRINDED_GREENBEAN,
	ZUNDA_ANKO,
	MOCHI,
	;
	/*
	GREEN_SOYBEAN,
	SUPER_ZUNDA_MOCHI,
	SUPER_ZUNDA_ANKO,
	BOILED_SUPER_GREENBEAN,
	GRINDED_SUPER_GREENBEAN,
	*/

	
	private boolean meat;
	private boolean fast;
	
	private MochiFoodEnum(boolean meat, boolean fast){ // コンストラクタ
		// FoodProperties に渡す設定
		this.meat = meat; // オオカミに食べさせることができるか。肉類。
		this.fast = fast; // 早く食べることができるか。例）昆布。
	}
	
	private MochiFoodEnum() { // コンストラクタ
		this(false, false);
	}
	
	public FoodProperties getFoodPropertiesBuilder() {
		// 食べ物に関するプロパティの設定を返す。
		// Food にはこの FoodProperties を渡さなければいけない。
		FoodProperties.Builder builder = new FoodProperties.Builder();
		if (meat) builder.meat(); 
		if (fast) builder.fast();
		return builder.nutrition(4).saturationMod(0.3f).build(); // saturationMod: 隠し満腹度
	}
}
