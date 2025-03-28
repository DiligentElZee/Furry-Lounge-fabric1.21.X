package net.diligentelzee.furrylounge.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent TWINX = new FoodComponent.Builder().nutrition(3)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f)
            .build();

    public static final FoodComponent SUSHI_FOX = new FoodComponent.Builder().nutrition(1)
            .saturationModifier(0.05f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 50), 0.025f)
            .build();

    public static final FoodComponent SNEPSI = new FoodComponent.Builder().nutrition(1)
            .saturationModifier(0.05f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 50), 0.025f)
            .build();
}