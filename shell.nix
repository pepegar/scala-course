{ java ? "openjdk14" }:

let
  sources = import ./nix/sources.nix;
  pkgs = import sources.nixpkgs {};
in
pkgs.mkShell {
  buildInputs = [
    pkgs.${java}
    pkgs.sbt
    pkgs.pandoc
    pkgs.entr
  ];
}
