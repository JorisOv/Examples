DEF hanim_c7 Segment {
	      name "l1"
	      children Shape {
		appearance Appearance {
		  material DEF Shirt_Color Material {
		    ambientIntensity 0.25
		    diffuseColor 0.6 0.0745 0.1137
		  }
		  texture DEF small_logo_Tex ImageTexture {
		    url "small_logo.gif"
		  }
		}
		geometry IndexedFaceSet {
		  coord Coordinate {
		    point [ 0.043 1.25 0.0614, 0.101 1.25 0.0614, 0.103 1.31 0.0195, 0.021 1.32 0.0276,
		      0.0572 1.27 -0.153, 0.0524 1.15 -0.134, 0 1.19 -0.14, 0 1.26 -0.147,
		      -0.0572 1.27 -0.153, -0.0228 1.18 -0.14, -0.0524 1.15 -0.134, 0 1.13 -0.126,
		      -0.0228 1.13 -0.124, 0 1.31 -0.146, -0.0545 1.35 -0.138, 0 1.35 -0.136,
		      -0.0593 1.3 -0.151, 0.0593 1.3 -0.151, 0.0545 1.35 -0.138, -0.0255 1.3 -0.146,
		      0.0975 1.26 -0.15, 0.1 1.3 -0.148, -0.1 1.3 -0.148, -0.0975 1.26 -0.15,
		      -0.117 1.41 -0.0395, -0.0674 1.45 -0.0314, -0.0926 1.41 -0.0937, -0.124 1.4 -0.0706,
		      -0.0583 1.44 -0.0615, -0.0228 1.46 -0.0872, -0.0534 1.42 -0.112, -0.0228 1.42 0.00351,
		      -0.0593 1.43 -0.0185, -0.0787 1.39 -0.00293, -0.112 1.4 -0.0131, -0.164 1.39 -0.0373,
		      -0.0153 1.39 0.0159, -0.0953 1.35 -0.136, -0.0545 1.35 -0.138, -0.139 1.34 0.00297,
		      -0.137 1.34 -0.0368, 0 1.35 -0.136, -0.156 1.35 -0.0915, -0.132 1.29 -0.127,
		      -0.1 1.3 -0.148, -0.0418 1.35 0.0168, -0.013 1.37 0.0167, -0.151 1.28 -0.0878,
		      -0.136 1.32 -0.0406, -0.124 1.26 -0.125, -0.0975 1.26 -0.15, 0.00228 1.37 0.0167,
		      -0.00959 1.32 0.0276, -0.0918 1.31 0.0195, -0.141 1.25 -0.0744, -0.0316 1.25 0.0614,
		      -0.00261 1.25 0.0458, -0.0611 1.25 0.0668, -0.0896 1.25 0.0614, -0.126 1.24 0.012,
		      -0.126 1.22 0.0141, -0.129 1.17 -0.0523, -0.115 1.16 -0.105, -0.0851 1.18 -0.134,
		      -0.0524 1.15 -0.134, -0.083 1.13 -0.122, -0.117 1.15 -0.018, -0.11 1.1 -0.0846,
		      -0.0808 1.1 -0.111, -0.0228 1.13 -0.124, -0.0524 1.1 -0.119, 0 1.13 -0.126,
		      -0.0228 1.1 -0.116, -0.0563 1.15 0.0377, -0.00476 1.18 0.0458, -0.0343 1.18 0.0485,
		      -0.0966 1.15 -0.00413, -0.12 1.1 -0.0373, -0.121 1.07 -0.0356, -0.106 1.07 -0.0711,
		      -0.0475 1.06 -0.105, 0 1.08 0.0556, -0.0787 1.08 0.0347, -0.103 1.08 0.00296,
		      -0.0975 1.01 -0.0873, -0.134 0.998 -0.0314, -0.0475 1.02 -0.109, -0.0325 1.02 0.0529,
		      0 1.02 0.0422, -0.0975 1.02 0.0132, 0.0926 1.41 -0.0937, 0.0674 1.45 -0.0314,
		      0.117 1.41 -0.0395, 0.124 1.4 -0.0706, 0.0583 1.44 -0.0615, 0.0534 1.42 -0.112,
		      0.0228 1.46 -0.0872, 0 1.4 -0.112, 0.0787 1.39 -0.00293, 0.0593 1.43 -0.0185,
		      0.0228 1.42 0.00351, 0.112 1.4 -0.0131, 0.164 1.39 -0.0373, 0.0153 1.39 0.0159,
		      0.0953 1.35 -0.136, 0.0545 1.35 -0.138, 0.139 1.34 0.00297, 0.156 1.35 -0.0915,
		      0.132 1.29 -0.127, 0.151 1.28 -0.0878, 0.1 1.3 -0.148, 0.137 1.34 -0.0368,
		      0.147 1.32 -0.0406, 0.124 1.26 -0.125, 0.0975 1.26 -0.15, 0.021 1.32 0.0276,
		      0.0532 1.35 0.0168, 0.103 1.31 0.0195, 0.135 1.29 -0.0406, 0.141 1.25 -0.0744,
		      0.132 1.18 -0.083, 0.134 1.19 -0.0572, 0.014 1.25 0.0458, 0.043 1.25 0.0614,
		      0.101 1.25 0.0614, 0.138 1.24 0.012, 0.065 1.23 0.0743, 0.115 1.16 -0.105,
		      0.0851 1.18 -0.134, 0.0524 1.15 -0.134, 0.043 1.2 0.0641, 0.127 1.14 -0.0427,
		      0.083 1.13 -0.122, 0.0162 1.18 0.0458, 0.0457 1.18 0.0485, 0.117 1.15 -0.018,
		      0.11 1.1 -0.0846, 0.0808 1.1 -0.111, 0.0524 1.1 -0.119, 0.0228 1.1 -0.116,
		      0.108 1.15 -0.00413, 0.12 1.1 -0.0373, 0.121 1.07 -0.0356, 0.106 1.07 -0.0711,
		      0.0475 1.06 -0.105, 0.0787 1.08 0.0347, 0.0844 1.15 0.0297, 0.103 1.08 0.00296,
		      0 1.07 -0.11, 0.0975 1.01 -0.0873, 0.134 0.998 -0.0475, 0.0475 1.02 -0.109,
		      0.0325 1.02 0.0529, 0.0975 1.02 0.0132, 0 1.02 -0.117, 0 1.44 -0.0389,
		      0 1.01 -0.0259, -0.104 1.19 0.0423, -0.0778 1.19 0.0642, -0.078 1.19 0.0644,
		      -0.0493 1.2 0.0664, -0.0281 1.22 0.0587, -0.104 1.2 0.0568, -0.0484 1.21 0.0692,
		      -0.0549 1.21 0.0708, -0.0806 1.21 0.0713, -0.0852 1.21 0.0703, 0.116 1.19 0.043,
		      0.114 1.21 0.0572, 0.0967 1.21 0.0701, 0.11 1.19 0.0502, 0.093 1.19 0.0622,
		      0.0832 1.19 0.0662, 0.0863 1.21 0.0728, 0.0154 1.21 0.0458, -0.00393 1.21 0.0458,
		      -0.0145 1.2 0.0512, 0.0534 1.35 0.0168 ]
		  }
		  coordIndex [ 0, 1, 2, -1, 3, 0, 2, -1, 4, 5, 6, -1, 6, 7, 4, -1,
		    8, 7, 6, -1, 6, 9, 8, -1, 9, 10, 8, -1, 6, 5, 11, -1,
		    9, 6, 12, -1, 11, 12, 6, -1, 12, 10, 9, -1, 7, 8, 13, -1,
		    13, 4, 7, -1, 14, 15, 16, -1, 15, 17, 13, -1, 4, 13, 17, -1,
		    17, 15, 18, -1, 13, 19, 15, -1, 19, 13, 8, -1, 19, 16, 15, -1,
		    16, 19, 8, -1, 17, 20, 4, -1, 5, 4, 20, -1, 18, 21, 17, -1,
		    20, 17, 21, -1, 16, 22, 14, -1, 22, 16, 23, -1, 8, 23, 16, -1,
		    23, 8, 10, -1, 24, 25, 26, -1, 26, 27, 24, -1, 25, 28, 26, -1,
		    28, 29, 30, -1, 30, 26, 28, -1, 31, 32, 33, -1, 32, 25, 33, -1,
		    25, 24, 34, -1, 33, 25, 34, -1, 24, 35, 34, -1, 27, 35, 24, -1,
		    33, 36, 31, -1, 27, 26, 37, -1, 37, 26, 30, -1, 38, 37, 30, -1,
		    33, 34, 39, -1, 39, 34, 35, -1, 39, 35, 40, -1, 41, 38, 30, -1,
		    35, 27, 42, -1, 37, 42, 27, -1, 40, 35, 42, -1, 42, 37, 43, -1,
		    37, 38, 44, -1, 44, 43, 37, -1, 36, 45, 46, -1, 36, 33, 45, -1,
		    40, 42, 47, -1, 43, 47, 42, -1, 47, 48, 40, -1, 39, 40, 48, -1,
		    47, 43, 49, -1, 43, 44, 49, -1, 50, 49, 44, -1, 51, 46, 52, -1,
		    46, 45, 52, -1, 52, 45, 53, -1, 33, 53, 45, -1, 33, 39, 53, -1,
		    49, 54, 47, -1, 48, 47, 54, -1, 55, 56, 52, -1, 57, 52, 53, -1,
		    57, 55, 52, -1, 58, 57, 53, -1, 59, 58, 53, -1, 53, 39, 59, -1,
		    39, 48, 59, -1, 59, 48, 54, -1, 58, 59, 60, -1, 54, 49, 61, -1,
		    59, 54, 61, -1, 60, 59, 61, -1, 49, 50, 62, -1, 63, 62, 50, -1,
		    62, 61, 49, -1, 64, 63, 50, -1, 63, 64, 65, -1, 65, 62, 63, -1,
		    66, 60, 61, -1, 62, 65, 67, -1, 68, 67, 65, -1, 64, 69, 70, -1,
		    64, 70, 65, -1, 70, 68, 65, -1, 69, 71, 72, -1, 72, 70, 69, -1,
		    73, 74, 75, -1, 66, 76, 60, -1, 67, 77, 62, -1, 62, 77, 61, -1,
		    77, 66, 61, -1, 66, 77, 78, -1, 77, 67, 79, -1, 79, 67, 68, -1,
		    79, 78, 77, -1, 68, 70, 80, -1, 70, 72, 80, -1, 80, 79, 68, -1,
		    74, 73, 81, -1, 73, 76, 82, -1, 82, 81, 73, -1, 76, 66, 83, -1,
		    78, 83, 66, -1, 83, 82, 76, -1, 78, 79, 84, -1, 79, 80, 84, -1,
		    84, 85, 78, -1, 86, 84, 80, -1, 81, 82, 87, -1, 87, 88, 81, -1,
		    82, 83, 89, -1, 83, 78, 89, -1, 89, 87, 82, -1, 78, 85, 89, -1,
		    90, 91, 92, -1, 92, 93, 90, -1, 90, 94, 91, -1, 95, 96, 94, -1,
		    94, 90, 95, -1, 29, 96, 97, -1, 96, 95, 97, -1, 97, 30, 29, -1,
		    30, 97, 41, -1, 41, 97, 95, -1, 98, 99, 100, -1, 98, 91, 99, -1,
		    101, 92, 91, -1, 98, 101, 91, -1, 101, 102, 92, -1, 92, 102, 93, -1,
		    36, 103, 31, -1, 51, 103, 36, 46, -1, 103, 100, 31, -1, 100, 103, 98,
		    -1, 104, 90, 93, -1, 90, 104, 95, -1, 95, 105, 41, -1, 104, 105, 95,
		    -1, 106, 101, 98, -1, 102, 101, 106, -1, 107, 93, 102, -1, 93, 107, 104,
		    -1, 108, 104, 107, -1, 107, 109, 108, -1, 110, 105, 104, -1, 104, 108, 110,
		    -1, 109, 107, 111, -1, 107, 102, 111, -1, 111, 102, 106, -1, 111, 112, 109,
		    -1, 106, 112, 111, -1, 113, 110, 108, -1, 110, 113, 114, -1, 51, 52, 115,
		    -1, 116, 115, 117, -1, 117, 106, 116, -1, 118, 109, 112, -1, 119, 108, 109,
		    -1, 108, 119, 113, -1, 109, 118, 119, -1, 120, 113, 119, -1, 119, 121, 120,
		    -1, 52, 56, 122, -1, 122, 115, 52, -1, 115, 122, 123, -1, 117, 124, 125,
		    -1, 106, 117, 125, -1, 118, 112, 106, 125, -1, 119, 118, 125, -1, 121, 119,
		    125, -1, 126, 124, 123, -1, 127, 114, 113, -1, 114, 127, 128, -1, 113, 120,
		    127, -1, 114, 128, 129, -1, 130, 126, 123, -1, 122, 130, 123, -1, 131, 120,
		    121, -1, 131, 127, 120, -1, 132, 129, 128, -1, 128, 127, 132, -1, 74, 81,
		    133, -1, 81, 134, 133, -1, 121, 135, 131, -1, 136, 132, 127, -1, 132, 136,
		    137, -1, 138, 71, 129, -1, 138, 129, 132, -1, 137, 138, 132, -1, 139, 72,
		    71, -1, 72, 139, 80, -1, 71, 138, 139, -1, 140, 135, 121, -1, 140, 121,
		    125, -1, 141, 127, 131, -1, 127, 141, 136, -1, 131, 135, 141, -1, 142, 141,
		    135, -1, 143, 136, 141, -1, 136, 143, 137, -1, 141, 142, 143, -1, 144, 138,
		    137, -1, 144, 139, 138, -1, 143, 144, 137, -1, 145, 146, 134, -1, 145, 140,
		    146, -1, 134, 81, 145, -1, 147, 135, 140, -1, 135, 147, 142, -1, 140, 145,
		    147, -1, 148, 80, 139, -1, 80, 148, 86, -1, 139, 144, 148, -1, 149, 143,
		    142, -1, 149, 144, 143, -1, 142, 150, 149, -1, 151, 148, 144, -1, 144, 149,
		    151, -1, 152, 145, 81, -1, 81, 88, 152, -1, 153, 147, 145, -1, 153, 142,
		    147, -1, 145, 152, 153, -1, 153, 150, 142, -1, 154, 86, 148, -1, 148, 151,
		    154, -1, 155, 28, 25, -1, 155, 29, 28, -1, 155, 25, 32, -1, 155, 32,
		    31, -1, 155, 31, 100, -1, 155, 100, 99, -1, 155, 99, 91, -1, 155, 91,
		    94, -1, 155, 94, 96, -1, 155, 96, 29, -1, 156, 151, 149, -1, 156, 154,
		    151, -1, 156, 149, 150, -1, 156, 150, 153, -1, 156, 153, 152, -1, 156, 152,
		    88, -1, 156, 88, 87, -1, 156, 87, 89, -1, 156, 89, 85, -1, 156, 85,
		    84, -1, 156, 84, 86, -1, 156, 86, 154, -1, 76, 157, 60, -1, 76, 73,
		    158, 157, -1, 159, 158, 73, 75, 160, -1, 161, 56, 55, -1, 60, 162, 58,
		    -1, 162, 60, 157, -1, 161, 55, 163, -1, 57, 164, 163, 55, -1, 160, 163,
		    164, -1, 160, 164, 159, -1, 164, 57, 165, -1, 164, 165, 159, -1, 57, 58,
		    166, 165, -1, 166, 58, 162, -1, 165, 166, 159, -1, 166, 162, 157, 158, 159,
		    -1, 140, 125, 167, -1, 124, 168, 125, -1, 168, 167, 125, -1, 124, 169, 168,
		    -1, 146, 140, 167, 170, -1, 168, 170, 167, -1, 168, 169, 170, -1, 146, 170,
		    171, -1, 169, 171, 170, -1, 172, 134, 146, 171, -1, 134, 172, 130, -1, 169,
		    124, 126, 173, -1, 173, 126, 130, -1, 169, 173, 172, 171, -1, 173, 130, 172,
		    -1, 122, 74, 133, 174, -1, 133, 134, 174, -1, 130, 122, 174, -1, 134, 130,
		    174, -1, 122, 56, 175, 74, -1, 74, 175, 176, -1, 175, 56, 161, 176, -1,
		    74, 176, 75, -1, 176, 161, 163, -1, 176, 160, 75, -1, 176, 163, 160, -1,
		    115, 116, 177, 51, -1, 106, 98, 177, 116, -1, 51, 177, 103, -1, 177, 98, 103, -1 ]
		  texCoord TextureCoordinate {
		    point [ 0.1611 -0.02056, 0.9468 -0.02056, 0.9739 0.9344, -0.137 1.094, 0.1973 0.6424,
		      0.2231 0.04876, 0.5054 0.2466, 0.5054 0.5929, 0.8135 0.6424, 0.6282 0.1972,
		      0.7876 0.04876, 0.5054 -0.05018, 0.6282 -0.05018, 0.5054 0.8403, 0.7989 1.038,
		      0.5054 1.038, 0.8248 0.7908, 0.186 0.7908, 0.2118 1.038, 0.6427 0.7908, -0.01977 0.5929,
		      -0.03324 0.7908, 1.044 0.7908, 1.031 0.5929, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0, 0 0,
		      0 0, 0 0, 0 0, ]
		  }
		  creaseAngle 1.59
		}
	      }
	    }