package main.java.snowball.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySnowball extends net.minecraft.entity.projectile.EntitySnowball {

    private static int POTION_SLOWNESS_ID = 2;

    @Override
    protected void onImpact(MovingObjectPosition objectPosition) {
        super.onImpact(objectPosition);

        if (objectPosition.entityHit != null)
        {
            if(objectPosition.entityHit instanceof EntityLivingBase)
            {
                EntityLivingBase entityHit = (EntityLivingBase)objectPosition.entityHit;

                ((EntityLivingBase) objectPosition.entityHit).addPotionEffect(new PotionEffect(POTION_SLOWNESS_ID, 250, 25));
                System.out.println("That's a hit!"); // I'm lazy, what do you want?
            }
        }
    }

    public EntitySnowball(World worldIn)
    {
        super(worldIn);
    }

    public EntitySnowball(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntitySnowball(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
}
