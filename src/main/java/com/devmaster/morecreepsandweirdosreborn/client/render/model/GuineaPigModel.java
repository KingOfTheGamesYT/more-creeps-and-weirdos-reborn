package com.devmaster.morecreepsandweirdosreborn.client.render.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.devmaster.morecreepsandweirdosreborn.entity.GuineaPig;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;

public class GuineaPigModel<G extends CreatureEntity> extends EntityModel<GuineaPig> {
	private final ModelRenderer main;
	private final ModelRenderer torso;
	private final ModelRenderer head;
	private final ModelRenderer leg_fr;
	private final ModelRenderer leg_fl;
	private final ModelRenderer leg_br;
	private final ModelRenderer leg_bl;

	public GuineaPigModel(float v) {
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, -2.0F, 0.0F);
		main.addChild(torso);
		torso.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 4.0F, 9.0F, 0.0F, false);
		torso.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 4.0F, 9.0F, 0.3F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(0, 13).addBox(-2.0F, -5.0F, -8.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(0, 13).addBox(-2.0F, -5.0F, -8.0F, 4.0F, 4.0F, 4.0F, 0.3F, false);

		leg_fr = new ModelRenderer(this);
		leg_fr.setRotationPoint(-2.0F, -2.0F, -3.0F);
		main.addChild(leg_fr);
		leg_fr.setTextureOffset(0, 0).addBox(-1.1F, 0.0F, -1.1F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		leg_fl = new ModelRenderer(this);
		leg_fl.setRotationPoint(2.0F, -2.0F, -3.0F);
		main.addChild(leg_fl);
		leg_fl.setTextureOffset(0, 0).addBox(-0.9F, 0.0F, -1.1F, 2.0F, 2.0F, 2.0F, 0.0F, true);

		leg_br = new ModelRenderer(this);
		leg_br.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(leg_br);
		leg_br.setTextureOffset(0, 4).addBox(-3.1F, -2.0F, 3.1F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		leg_bl = new ModelRenderer(this);
		leg_bl.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(leg_bl);
		leg_bl.setTextureOffset(0, 4).addBox(1.1F, -2.0F, 3.1F, 2.0F, 2.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(GuineaPig entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}