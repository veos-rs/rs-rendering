/*
 * Copyright 2018-2021 Guthix
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("unused")

package com.veosps.rsrendering.runescape.buffer

object SmallLong {
    const val SIZE_BYTES: Int = 6
    const val SIZE_BITS: Int = SIZE_BYTES * Byte.SIZE_BITS
    const val MAX_VALUE: Long = 140_737_488_355_327
    const val MIN_VALUE: Long = -140_737_488_355_328
}

object USmallLong {
    const val SIZE_BYTES: Int = SmallLong.SIZE_BYTES
    const val SIZE_BITS: Int = SmallLong.SIZE_BITS
    const val MAX_VALUE: ULong = 281_474_976_710_655u
    const val MIN_VALUE: ULong = 0u
}