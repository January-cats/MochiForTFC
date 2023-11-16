package jp.sheepsan.mochi_for_tfc;

import jp.sheepsan.mochi_for_tfc.init.ItemInit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mochi_for_tfc")
public class MochiForTFCMain {
	
	// refer log4j directly
	private static final Logger LOGGER = LogManager.getLogger();
	// declair MOD ID
	public static final String MOD_ID = "mochi_for_tfc";
	
	public MochiForTFCMain() {
		// register this mod
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		modEventBus.addListener(this::setup);
		ItemInit.ITEMS.register(modEventBus); // register all Items contained in ITEMS
		
		MinecraftForge.EVENT_BUS.register(this);
		LOGGER.info("Welcome to Mochi for TFC!");
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		// 登録されているオブジェクトの構成ファイル作成・読み取りと機能登録
	}

}
