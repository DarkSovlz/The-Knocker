package net.mcreator.theknocker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.theknocker.init.TheKnockerModEntities;
import net.mcreator.theknocker.init.TheKnockerModBlocks;
import net.mcreator.theknocker.entity.KnockerdeadanimalEntity;

import java.util.Map;
import java.util.Comparator;

public class DeadcoweventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity armor_stand = null;
		Entity knocker = null;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new ArmorStand(EntityType.ARMOR_STAND, _level);
			entityToSpawn.moveTo(x, 0, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		armor_stand = (Entity) world.getEntitiesOfClass(ArmorStand.class, AABB.ofSize(new Vec3(x, 0, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, 0, z)).findFirst().orElse(null);
		armor_stand.setInvisible(true);
		armor_stand.setNoGravity(true);
		armor_stand.getPersistentData().putString("dead_cow", "dead_cow");
		{
			Entity _ent = armor_stand;
			_ent.teleportTo(x, y, z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"spreadplayers ~ ~ 0 50 false @e[type=armor_stand,distance=..3]");
		{
			Entity _ent = armor_stand;
			_ent.teleportTo(x, (y + 1), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
		}
		if (world.getBlockState(new BlockPos(armor_stand.getX(), armor_stand.getY() - 1, armor_stand.getZ())).canOcclude()) {
			world.setBlock(new BlockPos(armor_stand.getX(), armor_stand.getY(), armor_stand.getZ()), TheKnockerModBlocks.DEADCOW.get().defaultBlockState(), 3);
		} else {
			{
				BlockPos _bp = new BlockPos(armor_stand.getX(), armor_stand.getY() - 1, armor_stand.getZ());
				BlockState _bs = TheKnockerModBlocks.DEADCOW.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new KnockerdeadanimalEntity(TheKnockerModEntities.KNOCKERDEADANIMAL.get(), _level);
			entityToSpawn.moveTo((armor_stand.getX() + 1), (armor_stand.getY()), (armor_stand.getZ()), world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		knocker = (Entity) world.getEntitiesOfClass(KnockerdeadanimalEntity.class, AABB.ofSize(new Vec3((armor_stand.getX()), (armor_stand.getY()), (armor_stand.getZ())), 4, 4, 4), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((armor_stand.getX()), (armor_stand.getY()), (armor_stand.getZ()))).findFirst().orElse(null);
		knocker.setNoGravity(true);
	}
}
