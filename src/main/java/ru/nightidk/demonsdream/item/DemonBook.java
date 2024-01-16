package ru.nightidk.demonsdream.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.NotNull;
import ru.nightidk.demonsdream.hooks.ClientHooks;

public class DemonBook extends Item {

    public static final String NAME = "demon_book";
    public DemonBook() {
        super(getProps());
    }

    public static String getLocalName() {
        return NAME;
    }
    private static Item.Properties getProps() {
        return new Properties().stacksTo(1);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (interactionHand != InteractionHand.MAIN_HAND) return InteractionResultHolder.pass(player.getItemInHand(interactionHand));
        if (!level.isClientSide) return InteractionResultHolder.pass(player.getItemInHand(interactionHand));


        if (player.getItemInHand(interactionHand).getItem() instanceof DemonBook) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openDemonBookScreen);
            return InteractionResultHolder.success(player.getItemInHand(interactionHand));
        }

        return InteractionResultHolder.fail(player.getItemInHand(interactionHand));
    }
}
