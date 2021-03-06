#
# Copyright 2011-2015 Jeff Bush
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#include "../../asm_macros.inc"

#
# Validate vector shuffle and getlane instructions
#


                .globl _start
_start:         lea s0, shuffle_indices
                load_v v0, (s0)
                lea s0, shuffle_values
                load_v v1, (s0)
                shuffle v2, v1, v0

                lea s0, shuffle_result
                load_v v3, (s0)
                cmpne_i s0, v2, v3
                bz s0, 1f
                call fail_test

1:              getlane s1, v1, 1
                assert_reg s1, 0x2f8789dc
                getlane s1, v1, 2
                assert_reg s1, 0x2441bc05
                move s0, 3
                getlane s1, v1, s0
                assert_reg s1, 0x926a7525

                call pass_test

                .align 64
shuffle_indices: .long 12, 4, 7, 0, 14, 1, 15, 10, 9, 5, 2, 11, 6, 8, 3, 13
shuffle_values: .long 0xd47c22a3, 0x2f8789dc, 0x2441bc05, 0x926a7525, 0x59cf7a0f, 0x1bd540f8, 0x7fbfa499, 0x2b5f3644
                .long 0x87c70592, 0x98b2d078, 0x84f6f597, 0xfa8de8f0, 0x6e56e899, 0x27d7de84, 0x9d750442, 0xc8816f8b
shuffle_result: .long 0x6e56e899, 0x59cf7a0f, 0x2b5f3644, 0xd47c22a3, 0x9d750442, 0x2f8789dc, 0xc8816f8b, 0x84f6f597
                .long 0x98b2d078, 0x1bd540f8, 0x2441bc05, 0xfa8de8f0, 0x7fbfa499, 0x87c70592, 0x926a7525, 0x27d7de84
