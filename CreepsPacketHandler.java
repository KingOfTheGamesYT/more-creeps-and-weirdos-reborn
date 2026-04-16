package com.devmaster.morecreepsandweirdosreborn.util;

import com.devmaster.morecreepsandweirdosreborn.misc.MoreCreepsAndWeirdosReborn;
import com.mojang.brigadier.Message;
import com.devmaster.morecreepsandweirdosreborn.misc.MoreCreepsAndWeirdosReborn;
import com.devmaster.morecreepsandweirdosreborn.common.networking.message.*;
import net.minecraftforge.fml.network.NetworkRegistry;
import org.spongepowered.asm.mixin.MixinEnvironment;

public class CreepsPacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(MoreCreepsAndWeirdosReborn.MOD_ID);

    private static int discriminatorId = 0;

    public static void registerMessages()
    {
        registerMessage(MessageOpenGuiTamableEntity.MessageHandler.class, MessageOpenGuiTamableEntity.class, MixinEnvironment.Side.CLIENT);

        registerMessage(MessageOpenGuiTamableEntityTraining.MessageHandler.class, MessageOpenGuiTamableEntityTraining.class, MixinEnvironment.Side.CLIENT);

        registerMessage(MessageChangeTamedEntityName.MessageHandler.class, MessageChangeTamedEntityName.class, MixinEnvironment.Side.SERVER);

        registerMessage(MessageSetEntityWanderState.MessageHandler.class, MessageSetEntityWanderState.class, MixinEnvironment.Side.SERVER);

        registerMessage(MessageSendBloodEffect.MessageHandler.class, MessageSendBloodEffect.class, MixinEnvironment.Side.CLIENT);

        registerMessage(MessagePlayWelcomeSound.MessageHandler.class, MessagePlayWelcomeSound.class, Side.CLIENT);

        registerMessage(MessageLevelUpTamedEntity.MessageHandler.class, MessageLevelUpTamedEntity.class, Side.SERVER);

        registerMessage(MessageLevelUpGuineaPigSkill.MessageHandler.class, MessageLevelUpGuineaPigSkill.class, Side.SERVER);

        registerMessage(MessagePlayPyramidDiscoveredSound.MessageHandler.class, MessagePlayPyramidDiscoveredSound.class, Side.CLIENT);

        registerMessage(MessagePlayBattleCastleSound.MessageHandler.class, MessagePlayBattleCastleSound.class, Side.CLIENT);

        registerMessage(MessageLevelUpHotdogSkill.MessageHandler.class, MessageLevelUpHotdogSkill.class, Side.SERVER);

        registerMessage(MessageDismountEntity.MessageHandler.class, MessageDismountEntity.class, Side.SERVER);

        registerMessage(MessageDismountEntity.MessageHandler.class, MessageDismountEntity.class, Side.CLIENT);

        registerMessage(MessageOpenGuiSneakySal.MessageHandler.class, MessageOpenGuiSneakySal.class, Side.CLIENT);

        registerMessage(MessageRipOffSal.MessageHandler.class, MessageRipOffSal.class, MixinEnvironment.Side.SERVER);

        registerMessage(MessageBuyItemFromSal.MessageHandler.class, MessageBuyItemFromSal.class, MixinEnvironment.Side.SERVER);

        registerMessage(MessageSetLawyerFine.MessageHandler.class, MessageSetLawyerFine.class, MixinEnvironment.Side.CLIENT);

        registerMessage(MessageOpenGuiTamableEntityName.MessageHandler.class, MessageOpenGuiTamableEntityName.class, Side.CLIENT);

        registerMessage(MessageSetJumping.MessageHandler.class, MessageSetJumping.class, MixinEnvironment.Side.SERVER);
    }

    public static <REQ extends Message, REPLY extends Message> void registerMessage(Class<? extends MessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, MixinEnvironment.Side side)
    {
        INSTANCE.registerMessage(messageHandler, requestMessageType, discriminatorId++, side);
    }
}
