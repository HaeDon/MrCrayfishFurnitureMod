package com.mrcrayfish.furniture.blocks;

import com.mrcrayfish.furniture.MrCrayfishFurnitureMod;
import com.mrcrayfish.furniture.gui.GuiEditValueContainer;
import com.mrcrayfish.furniture.tileentity.IValueContainer;
import com.mrcrayfish.furniture.tileentity.TileEntityTV;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Author: MrCrayfish
 */
public abstract class BlockAbstractTV extends BlockFurnitureTile
{
    private int width;
    private int height;
    private double screenYOffset;
    private double screenZOffset;

    public BlockAbstractTV(Material material, int width, int height, double screenYOffset, double screenZOffset)
    {
        super(material);
        this.width = width;
        this.height = height;
        this.screenYOffset = screenYOffset;
        this.screenZOffset = screenZOffset;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(worldIn.isRemote)
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof IValueContainer)
            {
                playerIn.openGui(MrCrayfishFurnitureMod.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityTV(width, height, screenYOffset, screenZOffset);
    }
}
