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
package org.spongepowered.api.data.type;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of vanilla {@link WoodType}s.
 */
public final class WoodTypes {

    // SORTFIELDS:ON

    public static final WoodType ACACIA = DummyObjectProvider.createFor(WoodType.class, "ACACIA");

    public static final WoodType BIRCH = DummyObjectProvider.createFor(WoodType.class, "BIRCH");

    public static final WoodType DARK_OAK = DummyObjectProvider.createFor(WoodType.class, "DARK_OAK");

    public static final WoodType JUNGLE = DummyObjectProvider.createFor(WoodType.class, "JUNGLE");

    public static final WoodType OAK = DummyObjectProvider.createFor(WoodType.class, "OAK");

    public static final WoodType SPRUCE = DummyObjectProvider.createFor(WoodType.class, "SPRUCE");

    // SORTFIELDS:OFF

    private WoodTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
