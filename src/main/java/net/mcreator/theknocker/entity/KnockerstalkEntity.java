
package net.mcreator.theknocker.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.theknocker.procedures.KnockerstalkOnEntityTickUpdateProcedure;
import net.mcreator.theknocker.init.TheKnockerModEntities;

public class KnockerstalkEntity extends PathfinderMob {
	public static final EntityDataAccessor<Boolean> DATA_chase = SynchedEntityData.defineId(KnockerstalkEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_counted = SynchedEntityData.defineId(KnockerstalkEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_ticks_watching = SynchedEntityData.defineId(KnockerstalkEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_breath_sound = SynchedEntityData.defineId(KnockerstalkEntity.class, EntityDataSerializers.INT);

	public KnockerstalkEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheKnockerModEntities.KNOCKERSTALK.get(), world);
	}

	public KnockerstalkEntity(EntityType<KnockerstalkEntity> type, Level world) {
		super(type, world);
		maxUpStep = 0.6f;
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_chase, false);
		this.entityData.define(DATA_counted, false);
		this.entityData.define(DATA_ticks_watching, 0);
		this.entityData.define(DATA_breath_sound, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Datachase", this.entityData.get(DATA_chase));
		compound.putBoolean("Datacounted", this.entityData.get(DATA_counted));
		compound.putInt("Dataticks_watching", this.entityData.get(DATA_ticks_watching));
		compound.putInt("Databreath_sound", this.entityData.get(DATA_breath_sound));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datachase"))
			this.entityData.set(DATA_chase, compound.getBoolean("Datachase"));
		if (compound.contains("Datacounted"))
			this.entityData.set(DATA_counted, compound.getBoolean("Datacounted"));
		if (compound.contains("Dataticks_watching"))
			this.entityData.set(DATA_ticks_watching, compound.getInt("Dataticks_watching"));
		if (compound.contains("Databreath_sound"))
			this.entityData.set(DATA_breath_sound, compound.getInt("Databreath_sound"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		KnockerstalkOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 50);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
