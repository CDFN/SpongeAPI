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
package org.spongepowered.api.world.volume.worker.function;

import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.Volume;

@FunctionalInterface
public interface VolumePredicate<V extends Volume, U extends UnmodifiableVolume, I, M extends MutableVolume> {

    boolean test(V volume, I element, int x, int y, int z);

    default VolumePredicate<V, U, I, M> and(VolumePredicate<V, U, ? super I, M> other) {
        return (volume, element, x, y, z) -> test(volume, element, x, y, z) && other.test(volume, element, x, y, z);
    }

    default VolumePredicate<V, U, I, M> negate() {
        return (v, i, x, y, z) -> !test(v, i, x, y, z);
    }

    default VolumePredicate<V, U, I, M> or(VolumePredicate<V, U, ? super I, M> other) {
        return (v, i, x, y, z) -> test(v, i, x, y, z) || other.test(v, i, x, y, z);
    }

}