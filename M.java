import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import java.util.Random;

public class M extends Applet implements Runnable {
    private int[] M = new int[32767];
    private Image offScreenImage;
    private Graphics offScreenGraphics;

    public void start() {
        (new Thread(this)).start();
    }

    public void run() {
        try {
            Random random1 = new Random();
            int[] i4 = new int[262144];
            random1.setSeed(18295169L);

            for(int i5 = 0; i5 < 262144; ++i5) {
                i4[i5] = i5 / 64 % 64 > 32 + (int) (Math.random() * 8) ? (int) (Math.random() * 8) + 1 : 0;
            }

            int[] i57 = new int[12288];

            for(int i6 = 1; i6 < 16; ++i6) {
                int i7 = 255 - (int) (Math.random() * 96);

                for (int i8 = 0; i8 < 48; ++i8) {
                    for (int i9 = 0; i9 < 16; ++i9) {
                        int i10 = 9858122;
                        if (i6 == 4) {
                            i10 = 8355711;
                        }

                        if(i6 == 1 && i8 < (i9 * i9 * 3 + i9 * 81 >> 2 & 3) + 18) {
                            i10 = 6990400;
                        } else if(i6 == 1 && i8 < (i9 * i9 * 3 + i9 * 81 >> 2 & 3) + 19) {
                            i7 = i7 * 2 / 3;
                        }

                        if (i6 == 1 && i8 < (i9 * i9 * 3 + i9 * 81 >> 2 & 3) + 18) {
                            i10 = 6990400;
                        } else if (i6 == 1 && i8 < (i9 * i9 * 3 + i9 * 81 >> 2 & 3) + 19) {
                            i7 = i7 * 2 / 3;
                        }

                        int i11;
                        int i12;
                        if(i6 == 7) {
                            i10 = 6771249;
                            if(i9 <= 0 || i9 >= 15 || (i8 <= 0 || i8 >= 15) && (i8 <= 32 || i8 >= 47)) {
                                if((int) (Math.random() * 2) == 0) {
                                    i7 = i7 * (150 - (i9 & 1) * 100) / 100;
                                }
                            } else {
                                i10 = 12359778;
                                i11 = i9 - 7;
                                i12 = (i8 & 15) - 7;
                                if(i11 < 0) {
                                    i11 = 1 - i11;
                                }

                                if(i12 < 0) {
                                    i12 = 1 - i12;
                                }

                                if(i12 > i11) {
                                    i11 = i12;
                                }

                                i7 = 196 - (int) (Math.random() * 32) + i11 % 3 * 32;
                            }
                        }

                        if(i6 == 5) {
                            i10 = 11876885;
                            if((i9 + i8 / 4 * 4) % 8 == 0 || i8 % 4 == 0) {
                                i10 = 12365733;
                            }
                        }

                        i11 = i7;
                        if (i8 >= 32) {
                            i11 = i7 / 2;
                        }

                        if(i6 == 8) {
                            i10 = 5298487;
                            if((int) (Math.random() * 2) == 0) {
                                i10 = 0;
                                i11 = 255;
                            }
                        }

                        i12 = (i10 >> 16 & 255) * i7 / 255 << 16 | (i10 >> 8 & 255) * i7 / 255 << 8 | (i10 & 255) * i7 / 255;
                        i57[i9 + i8 * 16 + i6 * 256 * 3] = i12;
                    }
                }
            }

            float f58 = 96.5F;
            float f60 = 65.0F;
            float f59 = 96.5F;
            float f61 = 0.0F;
            float f62 = 0.0F;
            float f64 = 0.0F;
            long j63 = System.currentTimeMillis();
            int i14 = -1;
            int i15 = 0;
            float f16 = 0.0F;
            float f17 = 0.0F;

            while (true) {
                float f18 = (float) Math.sin((double) f16);
                float f19 = (float) Math.cos((double) f16);
                float f20 = (float) Math.sin((double) f17);
                float f21 = (float) Math.cos((double) f17);

                float f26;
                int i70;
                while (System.currentTimeMillis() - j63 > 10L) {
                    float f22;
                    float f23;
                    if (this.M[2] > 0) {
                        f22 = (float) (this.M[2] - 428) / 214.0F * 2.0F;
                        f23 = (float) (this.M[3] - 240) / 120.0F * 2.0F;
                        float f24 = (float) Math.sqrt((double) (f22 * f22 + f23 * f23)) - 1.2F;
                        if (f24 < 0.0F) {
                            f24 = 0.0F;
                        }

                        if (f24 > 0.0F) {
                            f16 += f22 * f24 / 400.0F;
                            f17 -= f23 * f24 / 400.0F;
                            if (f17 < -1.57F) {
                                f17 = -1.57F;
                            }

                            if (f17 > 1.57F) {
                                f17 = 1.57F;
                            }
                        }
                    }

                    j63 += 10L;
                    f22 = 0.0F;
                    f23 = 0.0F;
                    f23 += (float) (this.M[119] - this.M[115]) * 0.02F;
                    f22 += (float) (this.M[100] - this.M[97]) * 0.02F;
                    f61 *= 0.5F;
                    f62 *= 0.99F;
                    f64 *= 0.5F;
                    f61 += f18 * f23 + f19 * f22;
                    f64 += f19 * f23 - f18 * f22;
                    f62 += 0.003F;

                    label265:
                    for (i70 = 0; i70 < 3; ++i70) {
                        float f25 = f58 + f61 * (float) ((i70 + 0) % 3 / 2);
                        f26 = f60 + f62 * (float) ((i70 + 1) % 3 / 2);
                        float f27 = f59 + f64 * (float) ((i70 + 2) % 3 / 2);

                        for (int i28 = 0; i28 < 12; ++i28) {
                            int i29 = (int) (f25 + (float) (i28 >> 0 & 1) * 0.6F - 0.3F) - 64;
                            int i30 = (int) (f26 + (float) ((i28 >> 2) - 1) * 0.8F + 0.65F) - 64;
                            int i31 = (int) (f27 + (float) (i28 >> 1 & 1) * 0.6F - 0.3F) - 64;
                            if (i29 < 0 || i30 < 0 || i31 < 0 || i29 >= 64 || i30 >= 64 || i31 >= 64 || i4[i29 + i30 * 64 + i31 * 4096] > 0) {
                                if (i70 == 1) {
                                    if (this.M[32] > 0 && f62 > 0.0F) {
                                        this.M[32] = 0;
                                        f62 = -0.1F;
                                    } else {
                                        f62 = 0.0F;
                                    }
                                }
                                continue label265;
                            }
                        }

                        f58 = f25;
                        f60 = f26;
                        f59 = f27;
                    }
                }

                boolean z66 = false;
                boolean z68 = false;
                if (this.M[1] > 0 && i14 > 0) {
                    i4[i14] = 0;
                    this.M[1] = 0;
                }

                if (this.M[0] > 0 && i14 > 0) {
                    i4[i14 + i15] = 1;
                    this.M[0] = 0;
                }

                int i71;
                int i73;
                for (i70 = 0; i70 < 12; ++i70) {
                    i71 = (int) (f58 + (float) (i70 >> 0 & 1) * 0.6F - 0.3F) - 64;
                    int i72 = (int) (f60 + (float) ((i70 >> 2) - 1) * 0.8F + 0.65F) - 64;
                    i73 = (int) (f59 + (float) (i70 >> 1 & 1) * 0.6F - 0.3F) - 64;
                    if (i71 >= 0 && i72 >= 0 && i73 >= 0 && i71 < 64 && i72 < 64 && i73 < 64) {
                        i4[i71 + i72 * 64 + i73 * 4096] = 0;
                    }
                }

                i70 = -1;

                for (i71 = 0; i71 < 214; ++i71) {
                    f26 = (float) (i71 - 107) / 90.0F;

                    for (i73 = 0; i73 < 120; ++i73) {
                        float f74 = (float) (i73 - 60) / 90.0F;
                        float f75 = 1.0F;
                        float f76 = f75 * f21 + f74 * f20;
                        float f77 = f74 * f21 - f75 * f20;
                        float f32 = f26 * f19 + f76 * f18;
                        float f33 = f76 * f19 - f26 * f18;
                        int i34 = 0;
                        int i35 = 255;
                        double d36 = 20.0D;
                        float f38 = 5.0F;

                        int i39;
                        for (i39 = 0; i39 < 3; ++i39) {
                            float f40 = f32;
                            if (i39 == 1) {
                                f40 = f77;
                            }

                            if (i39 == 2) {
                                f40 = f33;
                            }

                            float f41 = 1.0F / (f40 < 0.0F ? -f40 : f40);
                            float f42 = f32 * f41;
                            float f43 = f77 * f41;
                            float f44 = f33 * f41;
                            float f45 = f58 - (float) ((int) f58);
                            if (i39 == 1) {
                                f45 = f60 - (float) ((int) f60);
                            }

                            if (i39 == 2) {
                                f45 = f59 - (float) ((int) f59);
                            }

                            if (f40 > 0.0F) {
                                f45 = 1.0F - f45;
                            }

                            float f46 = f41 * f45;
                            float f47 = f58 + f42 * f45;
                            float f48 = f60 + f43 * f45;
                            float f49 = f59 + f44 * f45;
                            if (f40 < 0.0F) {
                                if (i39 == 0) {
                                    --f47;
                                }

                                if (i39 == 1) {
                                    --f48;
                                }

                                if (i39 == 2) {
                                    --f49;
                                }
                            }

                            while ((double) f46 < d36) {
                                int i50 = (int) f47 - 64;
                                int i51 = (int) f48 - 64;
                                int i52 = (int) f49 - 64;
                                if (i50 < 0 || i51 < 0 || i52 < 0 || i50 >= 64 || i51 >= 64 || i52 >= 64) {
                                    break;
                                }

                                int i53 = i50 + i51 * 64 + i52 * 4096;
                                int i54 = i4[i53];
                                if (i54 > 0) {
                                    int i67 = (int) ((f47 + f49) * 16.0F) & 15;
                                    int i69 = ((int) (f48 * 16.0F) & 15) + 16;
                                    if (i39 == 1) {
                                        i67 = (int) (f47 * 16.0F) & 15;
                                        i69 = (int) (f49 * 16.0F) & 15;
                                        if (f43 < 0.0F) {
                                            i69 += 32;
                                        }
                                    }

                                    int i55 = 0xFFFFFF;
                                    if (i53 != i14 || i67 > 0 && i69 % 16 > 0 && i67 < 15 && i69 % 16 < 15) {
                                        i55 = i57[i67 + i69 * 16 + i54 * 256 * 3];
                                    }

                                    if (f46 < f38 && i71 == this.M[2] / 4 && i73 == this.M[3] / 4) {
                                        i70 = i53;
                                        byte b65 = 1;
                                        if (f40 > 0.0F) {
                                            b65 = -1;
                                        }

                                        i15 = b65 << 6 * i39;
                                        f38 = f46;
                                    }

                                    if (i55 > 0) {
                                        i34 = i55;
                                        i35 = 255 - (int) (f46 / 20.0F * 255.0F);
                                        i35 = i35 * (255 - (i39 + 2) % 3 * 50) / 255;
                                        d36 = (double) f46;
                                    }
                                }

                                f47 += f42;
                                f48 += f43;
                                f49 += f44;
                                f46 += f41;
                            }
                        }

                        i39 = (i34 >> 16 & 255) * i35 / 255;
                        int i78 = (i34 >> 8 & 255) * i35 / 255;
                        int i79 = (i34 & 255) * i35 / 255;
                        offScreenGraphics.setColor(new java.awt.Color(i39, i78, i79));
                        offScreenGraphics.fillRect(i71, i73, 1, 1);
                    }
                }

                i14 = i70;
                repaint();
                Thread.sleep(2L);
                if (!this.isActive()) {
                    return;
                }
            }
        } catch (Exception exception56) {
        }
    }

    public boolean handleEvent(Event event1) {
		byte b2 = 0;
		switch(event1.id) {
		case 401:
			b2 = 1;
		case 402:
			this.M[event1.key] = b2;
			break;
		case 501:
			b2 = 1;
			this.M[2] = event1.x;
			this.M[3] = event1.y;
		case 502:
			if((event1.modifiers & 4) > 0) {
				this.M[1] = b2;
			} else {
				this.M[0] = b2;
			}
			break;
		case 503:
		case 506:
			this.M[2] = event1.x;
			this.M[3] = event1.y;
			break;
		case 505:
			this.M[2] = 0;
		}

		return true;
	}


    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(214, 120);
            offScreenGraphics = offScreenImage.getGraphics();
        }
        g.drawImage(offScreenImage, 0, 0, this);
    }
}
