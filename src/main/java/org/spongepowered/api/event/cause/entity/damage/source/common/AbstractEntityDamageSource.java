/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.event.cause.entity.damage.source.common;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;

import java.util.Objects;

public abstract class AbstractEntityDamageSource implements EntityDamageSource {

    private final DamageType apiDamageType;
    private final boolean absolute;
    private final boolean bypassesArmor;
    private final boolean scales;
    private final boolean explosive;
    private final boolean magic;
    private final boolean creative;
    private final boolean fire;
    private final double exhaustion;
    private final Entity source;

    protected AbstractEntityDamageSource(AbstractEntityDamageSourceBuilder<?, ?> builder) {
        this.apiDamageType = Objects.requireNonNull(builder.damageType, "DamageType cannot be null!");
        this.absolute = builder.absolute;
        this.bypassesArmor = builder.bypasses;
        this.scales = builder.scales;
        this.explosive = builder.explosion;
        this.magic = builder.magical;
        this.creative = builder.creative;
        this.fire = builder.fire;
        if (builder.exhaustion != null) {
            this.exhaustion = builder.exhaustion;
        } else if (this.absolute || this.bypassesArmor) {
            this.exhaustion = 0.0;
        } else {
            this.exhaustion = 0.1;
        }
        this.source = Objects.requireNonNull(builder.source, "Entity source cannot be null!");
    }

    @Override
    public Entity source() {
        return this.source;
    }

    @Override
    public DamageType type() {
        return this.apiDamageType;
    }

    @Override
    public boolean isAbsolute() {
        return this.absolute;
    }

    @Override
    public boolean isBypassingArmor() {
        return this.bypassesArmor;
    }

    @Override
    public boolean isScaledByDifficulty() {
        return this.scales;
    }

    @Override
    public boolean isExplosive() {
        return this.explosive;
    }

    @Override
    public boolean isMagic() {
        return this.magic;
    }

    @Override
    public boolean doesAffectCreative() {
        return this.creative;
    }

    @Override
    public boolean isFire() {
        return this.fire;
    }

    @Override
    public double exhaustion() {
        return this.exhaustion;
    }

    @SuppressWarnings("unchecked")
    public abstract static class AbstractEntityDamageSourceBuilder<T extends EntityDamageSource,
            B extends EntityDamageSource.EntityDamageSourceBuilder<T, B>>
            extends AbstractDamageSourceBuilder<T, B>
            implements EntityDamageSourceBuilder<T, B> {

        protected Entity source;

        @Override
        public B entity(Entity entity) {
            this.source = Objects.requireNonNull(entity, "Entity source cannot be null!");
            return (B) this;
        }

        @Override
        public B reset() {
            super.reset();
            this.damageType = null;
            return (B) this;
        }
    }
}
