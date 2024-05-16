package net.mcreator.theknocker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.theknocker.entity.KnockerstalklookedEntity;

import java.util.Comparator;

public class KnockerstalklookedOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).isEmpty()) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() + 1.5), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())));
			if (entity instanceof KnockerstalklookedEntity _datEntL8 && _datEntL8.getEntityData().get(KnockerstalklookedEntity.DATA_enter_house_event)) {
				if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _livEnt10 && _livEnt10.isSleeping())) {
					if (!entity.level.isClientSide())
						entity.discard();
				}
			}
			if (entity instanceof KnockerstalklookedEntity _datEntL12 && _datEntL12.getEntityData().get(KnockerstalklookedEntity.DATA_torch_event)) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
					if (!entity.level.isClientSide())
						entity.discard();
					world.setBlock(new BlockPos(entity.getX(), entity.getY() + 1, entity.getZ()), Blocks.AIR.defaultBlockState(), 3);
				}
			}
		}
		if ((entity instanceof KnockerstalklookedEntity _datEntI ? _datEntI.getEntityData().get(KnockerstalklookedEntity.DATA_breath_sound) : 0) == 50) {
			if (entity instanceof KnockerstalklookedEntity _datEntSetI)
				_datEntSetI.getEntityData().set(KnockerstalklookedEntity.DATA_breath_sound, 0);
		}
		if ((entity instanceof KnockerstalklookedEntity _datEntI ? _datEntI.getEntityData().get(KnockerstalklookedEntity.DATA_breath_sound) : 0) == 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:breath")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:breath")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
		}
		if (entity instanceof KnockerstalklookedEntity _datEntSetI)
			_datEntSetI.getEntityData().set(KnockerstalklookedEntity.DATA_breath_sound, (int) ((entity instanceof KnockerstalklookedEntity _datEntI ? _datEntI.getEntityData().get(KnockerstalklookedEntity.DATA_breath_sound) : 0) + 1));
	}
}
