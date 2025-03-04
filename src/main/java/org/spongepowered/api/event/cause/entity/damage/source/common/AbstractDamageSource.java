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

import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;

import java.util.Objects;

/**
 * An abstract implementation of {@link DamageSource} to allow plugins to create
 * their own damage sources without having to implement all the required
 * methods.
 *
 * <p>Note that extending this class at the least is a requirement for custom
 * damage sources as not doing so will simply not work.</p>
 */
public abstract class AbstractDamageSource implements DamageSource {

    private final DamageType apiDamageType;
    private final boolean absolute;
    private final boolean bypassesArmor;
    private final boolean scales;
    private final boolean explosive;
    private final boolean magic;
    private final boolean creative;
    private final boolean fire;
    private final double exhaustion;

    protected AbstractDamageSource(AbstractDamageSourceBuilder<?, ?> builder) {
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

}
