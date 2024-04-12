package xyz.templecheats.templeclient.features.module.modules.render.esp.sub;

import net.minecraft.tileentity.*;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import xyz.templecheats.templeclient.features.module.Module;
import xyz.templecheats.templeclient.util.render.RenderUtil;
import xyz.templecheats.templeclient.util.setting.impl.BooleanSetting;

public class Storage extends Module {
    /*
     * Settings
     */
    private final BooleanSetting chests = new BooleanSetting("Chests", this, true);
    private final BooleanSetting dispensers = new BooleanSetting("Dispensers", this, true);
    private final BooleanSetting eChests = new BooleanSetting("EChests", this, true);
    private final BooleanSetting furnaces = new BooleanSetting("Furnaces", this, true);
    private final BooleanSetting shulkers = new BooleanSetting("Shulkers", this, true);

    public Storage() {
        super("Storage", "Highlights different types of storage entities", Keyboard.KEY_NONE, Category.Render, true);
        registerSettings(chests, dispensers, eChests, furnaces, shulkers);
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent e) {
        for (TileEntity tileEntity: mc.world.loadedTileEntityList) {
            if (chests.booleanValue() && tileEntity instanceof TileEntityChest ||
                    eChests.booleanValue() && tileEntity instanceof TileEntityEnderChest ||
                    shulkers.booleanValue() && tileEntity instanceof TileEntityShulkerBox ||
                    dispensers.booleanValue() && tileEntity instanceof TileEntityDispenser ||
                    furnaces.booleanValue() && tileEntity instanceof TileEntityFurnace) {
                RenderUtil.blockESP(tileEntity.getPos());
            }
        }
    }
}