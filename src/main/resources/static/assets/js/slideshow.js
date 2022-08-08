
		localStorage.setItem('load', taodtsp);
		var images = [
				"https://firebasestorage.googleapis.com/v0/b/handlerimage.appspot.com/o/iPhone_11.jpg?alt=media&token=e91abc44-d296-419f-855a-312bef05393d",
				"https://firebasestorage.googleapis.com/v0/b/handlerimage.appspot.com/o/realme.jpg?alt=media&token=68b9df1e-6442-42e7-a649-137be9d646bf",
				"https://firebasestorage.googleapis.com/v0/b/handlerimage.appspot.com/o/iPhone7_Plus.jpg?alt=media&token=14cd2a48-8230-44ac-a624-3e660abe7616",
				"https://firebasestorage.googleapis.com/v0/b/handlerimage.appspot.com/o/huawei.png?alt=media&token=3841a2ce-d6fe-48d6-872f-6ab8e602c58d" ];
		num = 0;

		function taodtsp(hinhAnh, tenSP, donGia) {
			var sanPham = new Object();
			sanPham.hinhAnh = hinhAnh;
			sanPham.tenSP = tenSP;
			sanPham.donGia = donGia;

			return sanPham;

		}
		function next() {
			var x = document.getElementById("anh");
			num++;
			if (num >= images.length) {
				num = 0;
			}
			x.src = images[num];
		}
		function prev() {
			var x = document.getElementById("anh");
			num--;
			if (num < 0) {
				num = images.length - 1;
			}
			x.src = images[num];
		}
		setInterval(next, 3500);
