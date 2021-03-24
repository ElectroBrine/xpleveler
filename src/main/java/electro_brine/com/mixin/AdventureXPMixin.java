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
public abstract class AdventureXPMixin extends LivingEntity implements PlayerEntityExt {

    private int AdventureXP;

    protected AdventureXPMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    public void addXP(int amount) {
        AdventureXP += amount;
        System.out.println(AdventureXP);
    }
    @Inject(method = "writeCustomDataToTag", at = @At("RETURN"))
    public void writeCustomDataToTag(CompoundTag tag, CallbackInfo ci) {
        tag.putInt("AdventureXP", this.AdventureXP);
    }

    @Inject(method = "readCustomDataFromTag", at = @At("RETURN"))
    public void readCustomDataFromTag(CompoundTag tag, CallbackInfo ci) {
        AdventureXP = tag.getInt("AdventureXP");
    }
}


