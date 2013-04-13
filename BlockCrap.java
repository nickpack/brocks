/**
 * 
 */
package net.minecraft.src;

import java.util.Random;
/**
 * @author nickp666
 *
 */
public class BlockCrap extends Block {
	
	public BlockCrap(int i)
    {
        super(i, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public int idDropped(int i, Random random)
    {
        return 0;
    }
    
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	int block = Block.blockNetherQuartz.blockID;
    	int size = 10;
        for (int i1 = 0; i1 < size; i1++)
        {
            for (int j1 = 0; j1 < size; j1++)
            {
                world.setBlock(i+i1, j+j1, k, block);
                world.setBlock(i+i1, j+j1, k+(size-1), block);
                world.setBlock(i, j+j1, k+i1, block);
                world.setBlock(i+(size-1), j+j1, k+i1, block);
                world.setBlock(i+i1,j+(size-1),k+j1,block);
                world.setBlock(i+i1,j,k+j1,block);
            }
        }
        
        world.setBlock(i+1, j+3, k, 0);
        world.setBlock(i+1, j+2, k, 0);
        world.setBlock(i+1, j+1, k, 0);
        world.setBlock(i+2, j+3, k, 0);
        world.setBlock(i+2, j+2, k, 0);
        world.setBlock(i+2, j+1, k, 0);

        int offset = size % 2 == 0 ? (size / 2) - 1 : (size / 2);
        world.setBlock(i, j+offset-2, k+offset, Block.glass.blockID);
        world.setBlock(i, j+offset-2, k+offset+1, Block.glass.blockID);
        world.setBlock(i+offset, j+offset-2, k, Block.glass.blockID);
        world.setBlock(i+offset, j+offset-2, k+1, Block.glass.blockID);
        world.setBlock(i+(size-1), j+offset-2, k+offset, Block.glass.blockID);
        world.setBlock(i+offset, j+offset-2, k+(size-1), Block.glass.blockID);

        world.setBlock(i+1, j+1, k+(size-2), Block.chest.blockID);
        world.setBlock(i+(size-2), j+1, k+1, Block.workbench.blockID);
        world.setBlock(i+(size/2), j+1, k+1, Block.glowStone.blockID);
        world.setBlock(i+(size-2), j+1, k+(size-2), Block.furnaceIdle.blockID);
        
        return true;
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("grass_side");
    }
}
