package agusev2311.genes;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class CustomWorldGenerator extends ChunkGenerator {
    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunkData = createChunkData(world);

        int worldX = chunkX << 4;
        int worldZ = chunkZ << 4;

        int type = random.nextInt(4);
        int m1rand = random.nextInt(4);
        int m2rand = random.nextInt(4);
        int m3rand = random.nextInt(4);
        Material m1 = getBlockForNoiseValue(m1rand);
        Material m2 = getBlockForNoiseValue(m2rand);
        Material m3 = getBlockForNoiseValue(m3rand);

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunkData.setBlock(x, 0, z, Material.BEDROCK);
                chunkData.setBlock(x, 1, z, Material.BEDROCK);

                if ((x == 0) || (x == 15) || (z == 0) || (z == 15)) {
                    chunkData.setBlock(x, 2, z, m1);
                } else {
                    chunkData.setBlock(x, 2, z, m2);
                }
            }
        }

        if (type == 0) {
            for (int x = 5; x < 11; x++) {
                for (int z = 5; z < 11; z++) {
                    chunkData.setBlock(x, 3, z, m3);
                }
            }
            for (int x = 6; x < 10; x++) {
                for (int z = 6; z < 10; z++) {
                    chunkData.setBlock(x, 4, z, m3);
                }
            }
            for (int x = 7; x < 9; x++) {
                for (int z = 7; z < 9; z++) {
                    chunkData.setBlock(x, 5, z, m3);
                }
            }
        } else if (type == 1) {
            for (int y = 3; y < 318; y++) {
                if (y % 4 == 0) {
                    chunkData.setBlock(6, y, 6, m3);
                } else if (y % 4 == 1)  {
                    chunkData.setBlock(6, y, 7, m3);
                } else if (y % 4 == 2) {
                    chunkData.setBlock(7, y, 7, m3);
                } else {
                    chunkData.setBlock(7, y, 6, m3);
                }
            }
            chunkData.setBlock(7, 319, 6, Material.CAKE);
        } else if (type == 2) {

        } else if (type == 3) {

        }

        return chunkData;
    }

    private Material getBlockForNoiseValue(int number) {
        if (number == 1) {
            return Material.GLOWSTONE;
        } else if (number == 2) {
            return Material.OCHRE_FROGLIGHT;
        } else if (number == 3) {
            return Material.DEEPSLATE_GOLD_ORE;
        } else {
            return Material.SAND;
        }
    }
}