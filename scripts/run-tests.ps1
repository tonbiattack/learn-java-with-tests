param(
    [string]$MavenVersion = "3.9.16"
)

$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $PSScriptRoot
$toolsDir = Join-Path $root ".tools"
$mavenDir = Join-Path $toolsDir "apache-maven-$MavenVersion"
$mavenZip = Join-Path $toolsDir "apache-maven-$MavenVersion-bin.zip"
$mavenUrl = "https://dlcdn.apache.org/maven/maven-3/$MavenVersion/binaries/apache-maven-$MavenVersion-bin.zip"
$mvnCmd = Join-Path $mavenDir "bin\mvn.cmd"

New-Item -ItemType Directory -Force -Path $toolsDir | Out-Null

if (-not (Test-Path $mvnCmd)) {
    if (-not (Test-Path $mavenZip)) {
        Write-Host "Downloading Apache Maven $MavenVersion..."
        Invoke-WebRequest -Uri $mavenUrl -OutFile $mavenZip
    }

    Write-Host "Extracting Apache Maven $MavenVersion..."
    Expand-Archive -Path $mavenZip -DestinationPath $toolsDir -Force
}

& $mvnCmd -q test
