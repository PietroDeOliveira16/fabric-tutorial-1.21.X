package net.pietro.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.pietro.tutorialmod.entity.projectile.thrown.CatBombEntity;

public class CatBombItem extends Item implements ProjectileItem {
    public CatBombItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(
                null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!world.isClient) {
            CatBombEntity catBombItem = new CatBombEntity(world, user);
            catBombItem.setItem(itemStack);
            catBombItem.setVelocity(user, user.getPitch(), user.getYaw(), 0.5F, 1.5F, 1.0F);
            world.playSound(
                    null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_CAT_AMBIENT, SoundCategory.PLAYERS
            );
            world.spawnEntity(catBombItem);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.decrementUnlessCreative(1, user);
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        EggEntity eggEntity = new EggEntity(world, pos.getX(), pos.getY(), pos.getZ());
        eggEntity.setItem(stack);
        return eggEntity;
    }
}
