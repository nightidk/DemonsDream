package ru.nightidk.demonsdream.gui.demonbook;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import ru.nightidk.demonsdream.DemonsDream;

public class DemonBookMainScreen extends Screen {

    private static final Component TITLE = Component.translatable("gui.demonsdream.demonbook_title");
    public static final ResourceLocation TEXTURE_BACKGROUND = new ResourceLocation(DemonsDream.MOD_ID, "textures/gui/demonbook/background_main.png");

    private int leftPos, topPos;
    private final int imageWidth, imageHeight;

    // Buttons
    private static final Component TEST_BUTTON = Component.translatable("gui.demonsdream.demonbook.buttons.test_button");
    private Button test_button;

    public DemonBookMainScreen() {
        super(TITLE);

        this.imageWidth = 236;
        this.imageHeight = 226;
    }

    @Override
    protected void init() {
        super.init();

        if (this.minecraft == null) return;
        Level level = this.minecraft.level;
        if (level == null) return;

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        this.test_button = addRenderableWidget(
                Button.builder(
                        TEST_BUTTON,
                        this::handleTestButton
                )
                .bounds(this.leftPos + 8, this.topPos + 8, 20, 20)
                .tooltip(Tooltip.create(TEST_BUTTON))
                .build()
        );

    }

    private void handleTestButton(Button button) {

    }



    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(graphics);
        graphics.blit(TEXTURE_BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        super.render(graphics, mouseX, mouseY, partialTicks);

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
