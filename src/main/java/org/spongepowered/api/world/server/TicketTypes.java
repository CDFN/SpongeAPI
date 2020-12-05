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
package org.spongepowered.api.world.server;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.portal.Portal;
import org.spongepowered.math.vector.Vector3i;

import java.util.function.Supplier;

/**
 * Types of {@link Ticket tickets} that can be requested via the
 * {@link ChunkManager}.
 */
public final class TicketTypes {

    /**
     * Represents {@link Ticket tickets} that ensures the target
     * {@link Chunk chunks} are loaded, but are not guaranteed to be loaded at
     * any time in the future, that is, the lifetime of such a ticket is
     * effectively {@link Ticks#zero() zero ticks}.
     */
    public static final Supplier<TicketType<Vector3i>> FORCED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TicketType.class, "forced");

    /**
     * Represents {@link Ticket tickets} that are intended to ensure that the
     * target {@link Chunk chunks} around a {@link Portal} are loaded, ready to
     * accept {@link Entity entities} that travel through it.
     */
    public static final Supplier<TicketType<Vector3i>> PORTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TicketType.class, "portal");

    /**
     * Represents {@link Ticket tickets} that are intended to ensure that the
     * target {@link Chunk chunks} around an {@link Entity} are loaded after
     * teleportation.
     */
    public static final Supplier<TicketType<Entity>> POST_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TicketType.class, "post_teleport");


}
