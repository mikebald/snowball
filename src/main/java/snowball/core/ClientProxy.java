package main.java.snowball.core;

import main.java.snowball.Snowball;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Snowball.snowball, 0, new ModelResourceLocation("minecraft:snowball", "inventory"));
    }
}
