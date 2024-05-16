package net.mcreator.theknocker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.theknocker.network.TheKnockerModVariables;
import net.mcreator.theknocker.entity.KnockerEntity;

import java.util.Comparator;

public class KnockerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double random = 0;
		Entity player = null;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
			if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1.35);
				if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			} else if ((entity instanceof KnockerEntity _datEntL11 && _datEntL11.getEntityData().get(KnockerEntity.DATA_chaseortp)) == false) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().stop();
			}
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() + 1.5), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())));
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty() || entity instanceof KnockerEntity _datEntL21 && _datEntL21.getEntityData().get(KnockerEntity.DATA_chase)) {
				TheKnockerModVariables.MapVariables.get(world).sleep = true;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				if ((entity instanceof KnockerEntity _datEntL22 && _datEntL22.getEntityData().get(KnockerEntity.DATA_chaseortp)) == false) {
					random = Math.round(Mth.nextDouble(RandomSource.create(), 1, 2));
					if (random == 1) {
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1.35);
						if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						if (entity instanceof KnockerEntity _datEntSetL)
							_datEntSetL.getEntityData().set(KnockerEntity.DATA_chaseortp, true);
					} else {
						if (TheKnockerModVariables.knocker_trigger_knock) {
							if (!entity.level.isClientSide())
								entity.discard();
							StalkbedProcedure.execute(world, x, y, z);
						} else {
							if (entity instanceof KnockerEntity _datEntSetL)
								_datEntSetL.getEntityData().set(KnockerEntity.DATA_chaseortp, true);
						}
					}
				} else if ((entity instanceof KnockerEntity _datEntL36 && _datEntL36.getEntityData().get(KnockerEntity.DATA_chaseortp)) == true) {
					player = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null);
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((player.getX()), (player.getY()), (player.getZ()), 1.35);
					if (entity instanceof Mob _entity && player instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 20) {
						if (!entity.level.isClientSide())
							entity.discard();
					}
					if (entity.isPassenger()) {
						entity.stopRiding();
					}
					sx = -2;
					found = false;
					for (int index0 = 0; index0 < 4; index0++) {
						sy = -2;
						for (int index1 = 0; index1 < 4; index1++) {
							sz = -2;
							for (int index2 = 0; index2 < 4; index2++) {
								if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("minecraft:fence_gates")))
										|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("minecraft:trapdoors")))) {
									if ((entity instanceof KnockerEntity _datEntI ? _datEntI.getEntityData().get(KnockerEntity.DATA_fence_gate_cooldown) : 0) == 0) {
										if (player instanceof Player _player) {
											BlockPos _bp = new BlockPos(x + sx, y + sy, z + sz);
											_player.level.getBlockState(_bp).use(_player.level, _player, InteractionHand.MAIN_HAND, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
										}
										if (entity instanceof KnockerEntity _datEntSetI)
											_datEntSetI.getEntityData().set(KnockerEntity.DATA_fence_gate_cooldown, 20);
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if ((entity instanceof KnockerEntity _datEntI ? _datEntI.getEntityData().get(KnockerEntity.DATA_fence_gate_cooldown) : 0) > 0) {
						if (entity instanceof KnockerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(KnockerEntity.DATA_fence_gate_cooldown, (int) ((entity instanceof KnockerEntity _datEntI ? _datEntI.getEntityData().get(KnockerEntity.DATA_fence_gate_cooldown) : 0) - 1));
					}
					if (entity.getY() < player.getY() && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 7, 7, 7), e -> true).isEmpty()) {
						entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.3, (entity.getDeltaMovement().z())));
					}
				}
			}
		}
	}
}
