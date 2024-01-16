package ru.nightidk.demonsdream.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ru.nightidk.demonsdream.DemonsDream;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DemonsDream.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DEMONSDREAM_TAB = CREATIVE_MODE_TABS.register("demonsdream_tab",
            () -> CreativeModeTab.builder()
                    .icon(() ->
                    new ItemStack(ItemInit.DemonBookItemReg.get())
                    )
                    .title(Component.translatable("creativetab.demonsdream_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ItemInit.DemonBookItemReg.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
