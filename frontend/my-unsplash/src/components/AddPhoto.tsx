const AddPhoto = () => {
  return (
    <form className="w-[556px] rounded-xl  z-30 py-6 px-8 grid absolute top-[250px] left-1/2 -translate-x-1/2 trans bg-[#fff]">
      <h2 className="font-medium text-2xl">Add a new photo</h2>

      <div className="grid mt-5">
        <label
          className="text-sm font-medium text-brown mb-[10px]"
          htmlFor="label"
        >
          Label
        </label>
        <input
          className="w-full text- p-[18px] rounded-md border-[#4F4F4F] border-solid border-[1px]"
          type="text"
          name="label"
          placeholder="Suspendisse elit massa"
        />
        <label
          className="text-sm font-medium text-brown mb-[10px] mt-5"
          htmlFor="photo-url"
        >
          Photo URL
        </label>
        <input type="file" name="photo-url" accept="image/*" />
      </div>
      <div className="flex self-left mt-5">
        <button className="ml-auto text-grey" type="button">
          Cancel
        </button>
        <button
          className="ml-6 button-filter rounded-xl text-[#fff] text-base font-bold bg-button py-4 px-6"
          type="submit"
        >
          Submit
        </button>
      </div>
    </form>
  );
};

export default AddPhoto;
