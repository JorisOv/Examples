DEF hanim_pelvis Segment {
	      name "pelvis"
	      children Shape {
		appearance Appearance {
		  material DEF Pants_Color Material {
		    ambientIntensity 0.25
		    diffuseColor 0.054 0.233 0.39
		  }
		}
		geometry IndexedFaceSet {
		  coord Coordinate {
		    point [ 0 1.06 0.0218, 0.0561 1.07 0.00726, 0.0851 1.07 -0.0115, 0.104 1.07 -0.0497,
		      0.0851 1.07 -0.0851, 0.032 1.06 -0.0985, 0.0873 1.04 0.0078, 0.033 1.04 0.0395,
		      0.123 1.05 -0.0405, 0.0609 1.02 -0.106, 0.0894 0.996 -0.106, 0.143 1 -0.0309,
		      0.117 1 0.0164, 0.0314 0.999 0.0502, 0.0314 0.96 -0.13, 0.156 0.966 -0.0405,
		      0.156 0.968 -0.00724, 0.0341 0.954 0.0513, 0.115 0.96 -0.0916, 0.121 0.926 0.0352,
		      0.0357 0.92 0.0497, 0.0314 0.91 -0.146, 0.0991 0.91 -0.131, 0.169 0.883 -0.0448,
		      0.169 0.885 -0.00939, 0.123 0.873 0.0384, 0.0926 0.872 0.047, 0.0325 0.873 0.0287,
		      0.0293 0.866 -0.142, 0.102 0.869 -0.131, 0.129 0.868 -0.103, 0.0314 0.84 -0.125,
		      0.101 0.844 -0.122, 0.133 0.846 -0.0878, 0.0653 0.835 0.0132, 0.0615 0.824 -0.111,
		      0.0985 0.823 -0.101, 0.132 0.826 -0.0448, 0.0609 0.821 -0.0158, 0.0599 0.812 -0.0545,
		      0 1.08 -0.0266, -0.0561 1.07 0.00726, -0.0851 1.07 -0.0115, -0.104 1.07 -0.0497,
		      -0.0851 1.07 -0.0851, -0.032 1.06 -0.0985, -0.0873 1.04 0.0078, -0.033 1.04 0.0395,
		      -0.123 1.05 -0.0405, -0.0609 1.02 -0.106, 0 1.02 -0.108, -0.0894 0.996 -0.106,
		      -0.143 1 -0.0309, -0.144 1 -0.011, -0.117 1 0.0164, -0.0314 0.999 0.0502,
		      0 0.961 -0.123, -0.0314 0.96 -0.13, -0.156 0.966 -0.0405, -0.156 0.968 -0.00724,
		      -0.0341 0.954 0.0513, -0.115 0.96 -0.0916, -0.121 0.926 0.0352, -0.0357 0.92 0.0497,
		      0 0.91 -0.127, -0.0314 0.91 -0.146, -0.0991 0.91 -0.131, -0.167 0.911 -0.0448,
		      -0.167 0.912 -0.00671, 0 0.883 -0.129, -0.123 0.873 0.0384, -0.0926 0.872 0.047,
		      -0.0325 0.873 0.0287, -0.0293 0.866 -0.142, -0.102 0.869 -0.131, -0.129 0.868 -0.103,
		      -0.166 0.863 -0.0148, 0 0.863 -0.00456, -0.166 0.862 -0.0459, 0 0.858 -0.1,
		      -0.0314 0.84 -0.125, -0.101 0.844 -0.122, -0.0653 0.835 0.0132, 0 0.839 -0.0217,
		      0 0.835 -0.0867, -0.0615 0.824 -0.111, -0.0985 0.823 -0.101, -0.132 0.826 -0.0448,
		      -0.0609 0.821 -0.0158, 0 0.831 -0.0626, -0.0599 0.812 -0.0545 ]
		  }
		  coordIndex [ 0, 1, 40, -1, 1, 2, 40, -1, 2, 3, 40, -1, 3, 4, 40, -1, 4, 5, 40, -1, 5, 4, 9, -1,
		    4, 3, 8, -1, 3, 2, 8, -1, 2, 1, 6, -1, 0, 7, 1, -1, 7, 6, 1, -1, 6, 8, 2, -1,
		    9, 4, 10, -1, 4, 8, 10, -1, 8, 6, 12, -1, 7, 0, 47, -1, 50, 5, 9, -1, 7, 47, 55, -1,
		    55, 13, 7, -1, 50, 9, 56, -1, 9, 10, 14, -1, 10, 11, 15, -1, 11, 12, 16, -1, 12, 13, 19, -1,
		    13, 55, 17, -1, 60, 17, 55, -1, 17, 19, 13, -1, 19, 16, 12, -1, 16, 15, 11, -1, 15, 18, 10, -1,
		    14, 56, 9, -1, 56, 14, 64, -1, 17, 60, 20, -1, 20, 19, 17, -1, 21, 64, 14, -1, 14, 22, 21, -1,
		    15, 16, 24, -1, 16, 19, 24, -1, 19, 20, 26, -1, 24, 23, 15, -1, 64, 21, 69, -1, 21, 22, 29, -1,
		    19, 26, 25, -1, 20, 63, 27, -1, 27, 26, 20, -1, 25, 24, 19, -1, 30, 29, 22, -1, 29, 28, 21, -1,
		    28, 69, 21, -1, 27, 34, 26, -1, 69, 28, 79, -1, 29, 30, 32, -1, 30, 23, 33, -1, 23, 24, 37, -1,
		    25, 26, 34, -1, 83, 27, 77, -1, 37, 33, 23, -1, 33, 32, 30, -1, 31, 79, 28, -1, 79, 31, 84, -1,
		    32, 33, 36, -1, 24, 25, 37, -1, 34, 27, 83, -1, 83, 38, 34, -1, 34, 37, 25, -1, 37, 36, 33, -1,
		    36, 35, 32, -1, 84, 31, 89, -1, 31, 35, 89, -1, 35, 36, 39, -1, 36, 37, 39, -1, 38, 83, 89, -1,
		    89, 39, 38, -1, 39, 89, 35, -1, 40, 41, 0, -1, 40, 42, 41, -1, 40, 43, 42, -1, 40, 44, 43, -1,
		    40, 45, 44, -1, 49, 44, 45, -1, 48, 43, 44, -1, 48, 42, 43, -1, 46, 41, 42, -1, 41, 47, 0, -1,
		    41, 46, 47, -1, 42, 48, 46, -1, 51, 44, 49, -1, 51, 48, 44, -1, 48, 52, 53, -1, 49, 45, 50, -1,
		    56, 49, 50, -1, 57, 51, 49, -1, 58, 53, 52, -1, 59, 54, 53, -1, 62, 55, 54, -1, 55, 62, 60, -1,
		    54, 59, 62, -1, 53, 58, 59, -1, 51, 61, 58, -1, 49, 56, 57, -1, 64, 57, 56, -1, 67, 59, 58, -1,
		    68, 62, 59, -1, 60, 63, 20, -1, 60, 62, 63, -1, 59, 67, 68, -1, 58, 61, 67, -1, 57, 64, 65, -1,
		    65, 66, 57, -1, 71, 63, 62, -1, 69, 65, 64, -1, 74, 66, 65, -1, 78, 68, 67, -1, 70, 71, 62, -1,
		    63, 72, 27, -1, 63, 71, 72, -1, 68, 78, 76, -1, 67, 75, 78, -1, 66, 74, 75, -1, 65, 73, 74, -1,
		    65, 69, 73, -1, 77, 27, 72, -1, 71, 82, 72, -1, 79, 73, 69, -1, 81, 75, 74, -1, 82, 71, 70, -1,
		    77, 72, 83, -1, 73, 79, 80, -1, 84, 80, 79, -1, 86, 75, 81, -1, 83, 72, 82, -1, 82, 88, 83, -1,
		    70, 87, 82, -1, 81, 85, 86, -1, 89, 80, 84, -1, 89, 85, 80, -1, 90, 86, 85, -1, 90, 87, 86, -1,
		    89, 83, 88, -1, 88, 90, 89, -1, 85, 89, 90, -1, 50, 45, 5, -1, 45, 40, 5, -1, 10, 8, 11, -1,
		    8, 12, 11, -1, 18, 22, 10, -1, 22, 14, 10, -1, 57, 66, 51, -1, 66, 61, 51, -1, 51, 58, 48, -1,
		    58, 52, 48, -1, 48, 53, 46, -1, 53, 54, 46, -1, 76, 70, 68, -1, 70, 62, 68, -1, 29, 32, 28, -1,
		    28, 32, 31, -1, 32, 35, 31, -1, 85, 81, 80, -1, 81, 73, 80, -1, 81, 74, 73, -1, 39, 37, 38, -1,
		    37, 34, 38, -1, 82, 87, 88, -1, 87, 90, 88, -1, 87, 78, 86, -1, 78, 75, 86, -1, 61, 66, 67, -1,
		    66, 75, 67, -1, 22, 18, 15, -1, 23, 30, 15, -1, 30, 22, 15, -1, 13, 12, 7, -1, 12, 6, 7, -1,
		    46, 54, 47, -1, 54, 55, 47, -1, 87, 76, 78, -1, 87, 70, 76, -1 ]
		  creaseAngle 1.14
		}
	      }
	    }