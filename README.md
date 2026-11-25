# DrawTrees

A collection of plain Java programs that draw recursive trees with a small `Turtle` graphics helper backed by `BufferedImage`. The generated images are written as PNG files in the current directory. There are no external dependencies.

## Requirements

- Java 25 runtime (`java` on `PATH`).

## Run the main demo

From the repository root:

```bash
java src/RunArvores.java src/Arvores.java src/LabPImage.java src/Turtle.java
```

This generates the bundled tree images such as `arvore1.png`, `arvore2.png`, and the `arvore4a.png` / `arvore4b.png` comparison pairs.

## Run the additional tree

```bash
java src/ArvoreJo.java src/LabPImage.java src/Turtle.java
```

This writes `arvore_1.png` and prints one ratio value used by the original exercise.

## Fixes included

- `Turtle` now starts with full opacity (`255`) instead of full transparency.
- `LabPImage.setPixelTransparency` now preserves the blue channel instead of reading green twice.
- `LabPImage.setPixelRGBWithTransparency` ignores out-of-bounds coordinates instead of throwing.

## Notes

- Source names and generated file names are kept unchanged to preserve the original exercise behavior.
- Code comments are in English where they were updated.

## License

MIT — see `LICENSE`.
