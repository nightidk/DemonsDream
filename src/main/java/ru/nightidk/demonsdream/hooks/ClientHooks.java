package ru.nightidk.demonsdream.hooks;

import net.minecraft.client.Minecraft;
import ru.nightidk.demonsdream.gui.demonbook.DemonBookMainScreen;

public class ClientHooks {
    public static void openDemonBookScreen() {
        Minecraft.getInstance().setScreen(new DemonBookMainScreen());
    }
}
