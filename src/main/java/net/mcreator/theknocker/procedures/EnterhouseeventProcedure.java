package net.mcreator.theknocker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.theknocker.network.TheKnockerModVariables;
import net.mcreator.theknocker.init.TheKnockerModEntities;
import net.mcreator.theknocker.entity.KnockerstalklookedEntity;
import net.mcreator.theknocker.TheKnockerMod;

import java.util.Comparator;

public class EnterhouseeventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xdoor = 0;
		double ydoor = 0;
		double zdoor = 0;
		sx = -20;
		found = false;
		for (int index0 = 0; index0 < 40; index0++) {
			sy = -20;
			for (int index1 = 0; index1 < 40; index1++) {
				sz = -20;
				for (int index2 = 0; index2 < 40; index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("minecraft:doors")))) {
						found = true;
						xdoor = x + sx;
						ydoor = y + sy;
						zdoor = z + sz;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			TheKnockerModVariables.xdoor_knocker = xdoor;
			TheKnockerModVariables.ydoor_knocker = ydoor;
			TheKnockerModVariables.zdoor_knocker = zdoor;
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(xdoor, ydoor, zdoor), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(xdoor, ydoor, zdoor, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof Player _player) {
				BlockPos _bp = new BlockPos(xdoor, ydoor, zdoor);
				_player.level.getBlockState(_bp).use(_player.level, _player, InteractionHand.MAIN_HAND, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
			}
			TheKnockerMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new KnockerstalklookedEntity(TheKnockerModEntities.KNOCKERSTALKLOOKED.get(), _level);
					entityToSpawn.moveTo(TheKnockerModVariables.xdoor_knocker, (TheKnockerModVariables.ydoor_knocker - 1), TheKnockerModVariables.zdoor_knocker, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
				if (((Entity) world.getEntitiesOfClass(KnockerstalklookedEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof KnockerstalklookedEntity _datEntSetL)
					_datEntSetL.getEntityData().set(KnockerstalklookedEntity.DATA_enter_house_event, true);
			});
		}
	}
}
