package net.mcreator.theknocker.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theknocker.entity.KnockerEntity;

public class KnockerEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof KnockerEntity _datEntSetL)
			_datEntSetL.getEntityData().set(KnockerEntity.DATA_chase, true);
	}
}
