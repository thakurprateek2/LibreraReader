./link_to_mupdf_1.11.sh

ant clean-apk

ant arm pro
ant arm64 pro
ant arm+arm64 pro
ant x86 pro

./remove_all.sh
./install_all.sh
./clear-cache.sh
