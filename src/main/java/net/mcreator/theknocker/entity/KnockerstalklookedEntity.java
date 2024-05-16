
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

import net.mcreator.theknocker.procedures.KnockerstalklookedOnEntityTickUpdateProcedure;
import net.mcreator.theknocker.init.TheKnockerModEntities;

public class KnockerstalklookedEntity extends PathfinderMob {
	public static final EntityDataAccessor<Boolean> DATA_chase = SynchedEntityData.defineId(KnockerstalklookedEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_counted = SynchedEntityData.defineId(KnockerstalklookedEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_enter_house_event = SynchedEntityData.defineId(KnockerstalklookedEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_breath_sound = SynchedEntityData.defineId(KnockerstalklookedEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_torch_event = SynchedEntityData.defineId(KnockerstalklookedEntity.class, EntityDataSerializers.BOOLEAN);

	public KnockerstalklookedEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheKnockerModEntities.KNOCKERSTALKLOOKED.get(), world);
	}

	public KnockerstalklookedEntity(EntityType<KnockerstalklookedEntity> type, Level world) {
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
		this.entityData.define(DATA_enter_house_event, false);
		this.entityData.define(DATA_breath_sound, 0);
		this.entityData.define(DATA_torch_event, false);
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
		compound.putBoolean("Dataenter_house_event", this.entityData.get(DATA_enter_house_event));
		compound.putInt("Databreath_sound", this.entityData.get(DATA_breath_sound));
		compound.putBoolean("Datatorch_event", this.entityData.get(DATA_torch_event));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datachase"))
			this.entityData.set(DATA_chase, compound.getBoolean("Datachase"));
		if (compound.contains("Datacounted"))
			this.entityData.set(DATA_counted, compound.getBoolean("Datacounted"));
		if (compound.contains("Dataenter_house_event"))
			this.entityData.set(DATA_enter_house_event, compound.getBoolean("Dataenter_house_event"));
		if (compound.contains("Databreath_sound"))
			this.entityData.set(DATA_breath_sound, compound.getInt("Databreath_sound"));
		if (compound.contains("Datatorch_event"))
			this.entityData.set(DATA_torch_event, compound.getBoolean("Datatorch_event"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		KnockerstalklookedOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
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
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		return builder;
	}
}
