package main.java.snowball;

import main.java.snowball.core.CommonProxy;
import main.java.snowball.item.ItemSnowball;
import main.java.snowball.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod( modid=Reference.ID, name = Reference.NAME, version = Reference.VERSION_FULL, dependencies = Reference.DEPENDS)
public final class Snowball {

    @Mod.Instance
    public static Snowball instance;

    public static ItemSnowball snowball;

    @SidedProxy(serverSide = Reference.PROXY_SERVER, clientSide = Reference.PROXY_CLIENT )
    public static CommonProxy proxy;

    @Mod.EventHandler
    private void preInit( FMLPreInitializationEvent event )
    {
        snowball = new ItemSnowball();

        try {
            GameRegistry.addSubstitutionAlias("minecraft:snowball", GameRegistry.Type.ITEM, snowball);
        } catch (ExistingSubstitutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


    @Mod.EventHandler
    private void init( FMLInitializationEvent event )
    {
        proxy.registerRenders();
    }

    @Mod.EventHandler
    private void postInit( FMLPostInitializationEvent event )
    {

    }

}
