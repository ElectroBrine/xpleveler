package electro_brine.com.mixin;

import electro_brine.com.PlayerEntityExt;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class AdventurelvlMixin extends LivingEntity implements PlayerEntityExt {

    private int Adventurelvl;

    protected AdventurelvlMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    public void addlvl(int amount) {
        Adventurelvl += amount;
        System.out.println(Adventurelvl);
    }
    @Inject(method = "writeCustomDataToTag", at = @At("RETURN"))
    public void writeCustomDataToTag(CompoundTag tag, CallbackInfo ci) {
        tag.putInt("Adventurelvl", this.Adventurelvl);
    }

    @Inject(method = "readCustomDataFromTag", at = @At("RETURN"))
    public void readCustomDataFromTag(CompoundTag tag, CallbackInfo ci) {
        Adventurelvl = tag.getInt("Adventurelvl");
    }
}
