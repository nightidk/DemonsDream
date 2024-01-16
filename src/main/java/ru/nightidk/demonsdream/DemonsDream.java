package ru.nightidk.demonsdream;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ru.nightidk.demonsdream.init.CreativeTab;
import ru.nightidk.demonsdream.init.ItemInit;

@Mod(DemonsDream.MOD_ID)
public class DemonsDream
{
    public static final String MOD_ID = "demonsdream";

    public DemonsDream() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeTab.register(bus);
        ItemInit.register(bus);
    }
}