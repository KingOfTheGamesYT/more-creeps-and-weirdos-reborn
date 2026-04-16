package com.devmaster.morecreepsandweirdosreborn.entity;

//import com.devmaster.morecreepsandweirdosreborn.misc.DismountMessage;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class GuineaPig extends TameableEntity {
    private static final DataParameter<Integer> GUINEA_PIG_VARIANT = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<String> GUINEA_PIG_NAME = EntityDataManager.createKey(GuineaPig.class, DataSerializers.STRING);
    private static final DataParameter<Integer> GUINEA_PIG_LEVEL = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_SPEED_BOOST = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<String> GUINEA_PIG_OWNER = EntityDataManager.createKey(GuineaPig.class, DataSerializers.STRING);
    private static final DataParameter<Integer> GUINEA_PIG_WANDER_STATE = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_EXP = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_TOTAL_DAMAGE = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<String> GUINEA_PIG_CREEP_TYPE_NAME = EntityDataManager.createKey(GuineaPig.class, DataSerializers.STRING);
    private static final DataParameter<Float> GUINEA_PIG_MODEL_SIZE = EntityDataManager.createKey(GuineaPig.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> GUINEA_PIG_SKILL_HEALING = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_SKILL_ATTACK = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_SKILL_DEFEND = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_SKILL_SPEED = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_INTEREST = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_HEAL_TIMER = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_HEALTH_BOOST = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_CRIT_COOLDOWN = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_ARMOR = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GUINEA_PIG_DISMOUNT_TIMER = EntityDataManager.createKey(GuineaPig.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> GUINEA_PIG_NO_DESPAWN = EntityDataManager.<Boolean>createKey(GuineaPig.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Float> GUINEA_PIG_HAMMER_SWING = EntityDataManager.createKey(GuineaPig.class, DataSerializers.FLOAT);

    public GuineaPig(final EntityType<? extends GuineaPig> type, final World worldIn) {
        super(type, worldIn);
        this.experienceValue = 5;

    }

    static class GuineaPigData extends AgeableEntity.AgeableData {
        public final int variant;

        private GuineaPigData(int x) {
            super(false);
            this.variant = x;
        }
    }

    public int getGuineaVariant() {
        return MathHelper.clamp((Integer)this.dataManager.get(GUINEA_PIG_VARIANT), 0, 3);
    }

    public void setGuineaPigVariant(int variant) {
        this.dataManager.set(GUINEA_PIG_VARIANT, variant);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(GUINEA_PIG_VARIANT, 0);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setGuineaPigVariant(compound.getInt("Variant"));
    }

    public static AttributeModifierMap.MutableAttribute getAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 200)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0D)
                .createMutableAttribute(Attributes.ARMOR, 2.5)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 180)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, AbstractGroupFishEntity.class, true));
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance diff, SpawnReason spawn, @Nullable ILivingEntityData spawndata, @Nullable CompoundNBT comnbt) {
        int x;
        if (spawndata instanceof GuineaPig.GuineaPigData) {
            x = ((GuineaPig.GuineaPigData)spawndata).variant;
        } else {
            x = this.rand.nextInt(3);
            spawndata = new GuineaPig.GuineaPigData(x);
        }

        this.setGuineaPigVariant(x);
        return super.onInitialSpawn(world, diff, spawn, (ILivingEntityData)spawndata, comnbt);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.8F;
    }

    @Override
    protected float getSoundPitch() {
        return 0.7F + rand.nextFloat() * 0.2F;
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return true;
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    protected boolean isDespawnPeaceful() {
        return false;
    }

    public void writeAdditional(CompoundNBT comnbt) {
        super.writeAdditional(comnbt);
        comnbt.putInt("Variant", this.getGuineaVariant());
    }
    protected void onDismount(Entity entity)
    {
    }


        }