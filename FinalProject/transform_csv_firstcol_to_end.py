#!/usr/bin/env python3
"""
Safely move the first CSV column to the end for each file in the phrases folder.

This script parses CSV files with the csv module (handles quoted fields with commas),
rotates the first column to the end for each non-empty row, and rewrites the files in-place.

Run from the FinalProject folder:
    python3 transform_csv_firstcol_to_end.py
"""
import csv
from pathlib import Path

FILES = [
    Path("phrases/italian_phrases.csv"),
    Path("phrases/portuguese_phrases.csv"),
    Path("phrases/turkish_phrases.csv"),
]


def transform_file(p: Path):
    if not p.exists():
        print(f"Skipping missing file: {p}")
        return

    # Read all rows using csv.reader to handle quoted commas
    with p.open("r", encoding="utf-8", newline="") as fh:
        reader = csv.reader(fh, skipinitialspace=True)
        rows = [row for row in reader]

    if not rows:
        print(f"Empty file: {p}")
        return

    new_rows = []
    for row in rows:
        # Keep empty rows as-is
        if not row:
            new_rows.append(row)
            continue
        # Move first field to the end
        first = row.pop(0)
        row.append(first)
        new_rows.append(row)

    # Write back using csv.writer
    with p.open("w", encoding="utf-8", newline="") as fh:
        writer = csv.writer(fh, quoting=csv.QUOTE_MINIMAL)
        writer.writerows(new_rows)

    print(f"Transformed: {p}")


def main():
    for f in FILES:
        transform_file(f)


if __name__ == "__main__":
    main()
