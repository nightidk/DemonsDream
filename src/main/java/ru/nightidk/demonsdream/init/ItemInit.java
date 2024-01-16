package ru.nightidk.demonsdream.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.nightidk.demonsdream.DemonsDream;
import ru.nightidk.demonsdream.item.DemonBook;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemonsDream.MOD_ID);

    public static final RegistryObject<Item> DemonBookItemReg = ITEMS.register(DemonBook.getLocalName(), DemonBook::new);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
