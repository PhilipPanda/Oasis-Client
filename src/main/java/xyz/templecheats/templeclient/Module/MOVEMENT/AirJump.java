package xyz.templecheats.templeclient.Module.MOVEMENT;

import xyz.templecheats.templeclient.Module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class AirJump extends Module {
    public AirJump() {
        super("AirJump", Keyboard.KEY_NONE, Category.MOVEMENT);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (mc.gameSettings.keyBindJump.isPressed()) {
            mc.player.jump();
        }
    }
}
