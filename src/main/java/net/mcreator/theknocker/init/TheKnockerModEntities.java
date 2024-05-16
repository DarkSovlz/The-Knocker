
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theknocker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.theknocker.entity.KnockerstalklookedEntity;
import net.mcreator.theknocker.entity.KnockerstalkEntity;
import net.mcreator.theknocker.entity.KnockerdeadanimalEntity;
import net.mcreator.theknocker.entity.KnockerEntity;
import net.mcreator.theknocker.TheKnockerMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheKnockerModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheKnockerMod.MODID);
	public static final RegistryObject<EntityType<KnockerEntity>> KNOCKER = register("knocker",
			EntityType.Builder.<KnockerEntity>of(KnockerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KnockerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KnockerstalkEntity>> KNOCKERSTALK = register("knockerstalk",
			EntityType.Builder.<KnockerstalkEntity>of(KnockerstalkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KnockerstalkEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KnockerstalklookedEntity>> KNOCKERSTALKLOOKED = register("knockerstalklooked",
			EntityType.Builder.<KnockerstalklookedEntity>of(KnockerstalklookedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KnockerstalklookedEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KnockerdeadanimalEntity>> KNOCKERDEADANIMAL = register("knockerdeadanimal",
			EntityType.Builder.<KnockerdeadanimalEntity>of(KnockerdeadanimalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KnockerdeadanimalEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			KnockerEntity.init();
			KnockerstalkEntity.init();
			KnockerstalklookedEntity.init();
			KnockerdeadanimalEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(KNOCKER.get(), KnockerEntity.createAttributes().build());
		event.put(KNOCKERSTALK.get(), KnockerstalkEntity.createAttributes().build());
		event.put(KNOCKERSTALKLOOKED.get(), KnockerstalklookedEntity.createAttributes().build());
		event.put(KNOCKERDEADANIMAL.get(), KnockerdeadanimalEntity.createAttributes().build());
	}
}
