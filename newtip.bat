@echo off
setlocal enableextensions disabledelayedexpansion

for /f "tokens=3,* delims=\" %%a in ("%1") do set "tip=%%b"

hugo new --kind tip examples/%tip%
