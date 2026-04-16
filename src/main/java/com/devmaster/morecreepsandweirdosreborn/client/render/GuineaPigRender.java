package com.devmaster.morecreepsandweirdosreborn.client.render;

import com.devmaster.morecreepsandweirdosreborn.client.render.model.GuineaPigModel;
import com.devmaster.morecreepsandweirdosreborn.entity.GuineaPig;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GuineaPigRender extends MobRenderer<GuineaPig, GuineaPigModel<GuineaPig>> {
    protected static final ResourceLocation[] TEXTURE = new ResourceLocation[]{new ResourceLocation("morecreepsandweirdosreborn", "textures/entity/guinea_pig_1.png"), new ResourceLocation("morecreepsandweirdosreborn", "textures/entity/guinea_pig_2.png"), new ResourceLocation("morecreepsandweirdosreborn", "textures/entity/guinea_pig_3.png")};

    public GuineaPigRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GuineaPigModel<>(0.0F), 0.7F);
    }

    public ResourceLocation getEntityTexture(GuineaPig entity) {
        return TEXTURE[entity.getGuineaVariant()];
    }

}

