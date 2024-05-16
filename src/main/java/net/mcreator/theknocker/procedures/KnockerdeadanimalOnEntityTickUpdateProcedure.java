package net.mcreator.theknocker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.theknocker.entity.KnockerdeadanimalEntity;
import net.mcreator.theknocker.TheKnockerMod;

import java.util.Comparator;

public class KnockerdeadanimalOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity armor_stand = null;
		Entity player = null;
		if (!world.getEntitiesOfClass(ArmorStand.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			armor_stand = (Entity) world.getEntitiesOfClass(ArmorStand.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((player.getX()), (player.getY() + 1.5), (player.getZ())));
			if (!(entity instanceof KnockerdeadanimalEntity _datEntL8 && _datEntL8.getEntityData().get(KnockerdeadanimalEntity.DATA_jumpscare_proc))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:sharpening_knife_2")), SoundSource.AMBIENT, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:sharpening_knife_2")), SoundSource.AMBIENT, 1, 1, false);
					}
				}
				TheKnockerMod.queueServerWork(20, () -> {
					if (!world.getEntitiesOfClass(ArmorStand.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()) {
						if (!((Entity) world.getEntitiesOfClass(ArmorStand.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).level.isClientSide())
							((Entity) world.getEntitiesOfClass(ArmorStand.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
					}
					if (!entity.level.isClientSide())
						entity.discard();
					JumpscareProcedure.execute(world, x, y, z);
				});
				if (entity instanceof KnockerdeadanimalEntity _datEntSetL)
					_datEntSetL.getEntityData().set(KnockerdeadanimalEntity.DATA_jumpscare_proc, true);
			}
		} else {
			if (!world.getEntitiesOfClass(ArmorStand.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((armor_stand.getX()), (armor_stand.getY()), (armor_stand.getZ())));
			}
		}
	}
}
